package com..chinamobile.demo.microservice.eureka.server.filter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import com..chinamobile.demo.microservice.util.log.LogIdThreadLocal;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @ClassName: CustomFilter   
 * @Description: 记录接口请求和返回报文日志过滤器,添加全局日志id到请求头 
 * @author: 张力  
 * @date:2017年10月25日 下午10:24:55
 */
@Component
public class LogFilter implements Filter {
	

	private static final Logger logger = LoggerFactory.getLogger("INTERFACE");


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 设置客户端一次请求日志id
		Long logId = LogIdThreadLocal.getLogId();
		MDC.put("LogId", logId.toString());
		long startTime = System.currentTimeMillis();
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String uri = request.getRequestURI();
		String serviceRoutePath = uri.substring(0, uri.indexOf("/", 1) + 1);
		

		BufferRequest bufferRequest = new BufferRequest(request);
		BufferResponse bufferResponse = new BufferResponse(response);

		bufferRequest.putHeader("log-id", logId.toString());

		// 获取来访ip,请求行，请求头，请求body信息
		String method = bufferRequest.getMethod();
		Map<String, Object> requestLinkedHashMap = new LinkedHashMap<String, Object>();
		requestLinkedHashMap.put("remoteAddr", bufferRequest.getRemoteAddr());
		requestLinkedHashMap.put("Request Line",
				bufferRequest.getMethod() + " " + bufferRequest.getRequestURL().toString());
		Enumeration<String> headerNames = bufferRequest.getHeaderNames();
		Map<String, String> headerHashMap = new LinkedHashMap<String, String>();
		while (headerNames.hasMoreElements()) {
			String element = headerNames.nextElement();
			headerHashMap.put(element, bufferRequest.getHeader(element));
		}
		requestLinkedHashMap.put("Request Headers", headerHashMap);
		requestLinkedHashMap.put("Request Body", "######");
		String contentType = bufferRequest.getHeader("content-type");

		ObjectMapper objectMapper = new ObjectMapper();
		String requstInfo = objectMapper.writeValueAsString(requestLinkedHashMap);

		if ("POST".equals(method)) {
			if (contentType.indexOf("application/json") > -1 || contentType.indexOf("application/xml") > -1) {

				String requestBody = new String(bufferRequest.getBuffer(), bufferRequest.getCharacterEncoding());
				requstInfo = requstInfo.replace("\"######\"", requestBody);
			}
		}

		logger.info(requstInfo);

		// 将日志id添加至请求头中

		chain.doFilter(bufferRequest, bufferResponse);
		byte[] out = bufferResponse.getBuffer();
		response.getOutputStream().write(out);

		// 获取响应行，响应头，响应body信息
		Map<String, Object> responseLinkedHashMap = new LinkedHashMap<String, Object>();
		responseLinkedHashMap.put("Response Line", bufferResponse.getStatus());
		Map<String, String> responseHeaderHashMap = new LinkedHashMap<String, String>();
		// response.setContentLength(out.length);
		Collection<String> responseHeaderNames = bufferResponse.getHeaderNames();
		for (String responseHeaderName : responseHeaderNames) {
			responseHeaderHashMap.put(responseHeaderName, bufferResponse.getHeader(responseHeaderName));
		}
		responseHeaderHashMap.put("content-type", bufferResponse.getContentType());
		responseLinkedHashMap.put("Response headers", responseHeaderHashMap);
		responseLinkedHashMap.put("Response Body", "######");

		long endTime = System.currentTimeMillis();
		responseLinkedHashMap.put("intTotalTime", endTime - startTime);
		String reponseInfo = objectMapper.writeValueAsString(responseLinkedHashMap);
		if (bufferResponse.getContentType() != null && (bufferResponse.getContentType().indexOf("application/json") > -1
				|| bufferResponse.getContentType().indexOf("application/xml") > -1)) {
			String reponseData = new String(out, response.getCharacterEncoding());
			reponseInfo = reponseInfo.replace("\"######\"", reponseData);
		}
		logger.info(reponseInfo);
	}

	@Override
	public void destroy() {

	}

}

class BufferRequest extends HttpServletRequestWrapper {
	private ByteArrayInputStream bin;
	private byte[] requestBody;
	private BufferedReader reader;
	private HttpServletRequest request;
	private final Map<String, String> customHeaders;

	public BufferRequest(HttpServletRequest request) throws IOException {
		super(request);
		this.request = request;
		requestBody = IOUtils.toByteArray(this.request.getReader(), request.getCharacterEncoding());
		bin = new ByteArrayInputStream(requestBody);
		this.customHeaders = new HashMap<String, String>();
	}

	@Override
	public BufferedReader getReader() throws IOException {
		reader = new BufferedReader(new InputStreamReader(bin, request.getCharacterEncoding()));
		return reader;
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {

		return new CustomServletInputStream(bin);
	}

	public byte[] getBuffer() {
		return requestBody;
	}

	void putHeader(String name, String value) {
		this.customHeaders.put(name, value);
	}

	@Override
	public String getHeader(String name) {
		// check the custom headers first
		String headerValue = customHeaders.get(name);

		if (headerValue != null) {
			return headerValue;
		}
		// else return from into the original wrapped object
		return ((HttpServletRequest) getRequest()).getHeader(name);
	}

	@Override
	public Enumeration<String> getHeaders(String name) {
		// create a set of the custom header names
		String headerValue = customHeaders.get(name);

		if (headerValue != null) {
			Set<String> set = new HashSet<>();
			set.add(headerValue);
			return Collections.enumeration(set);
		} else {

			// now add the headers from the wrapped request object
			return ((HttpServletRequest) getRequest()).getHeaders(name);

		}

	}

	@Override
	public Enumeration<String> getHeaderNames() {
		// create a set of the custom header names
		Set<String> set = new HashSet<>(customHeaders.keySet());

		// now add the headers from the wrapped request object
		Enumeration<String> e = ((HttpServletRequest) getRequest()).getHeaderNames();
		while (e.hasMoreElements()) {
			// add the names of the request headers into the list
			String n = e.nextElement();
			set.add(n);
		}

		// create an enumeration from the set and return
		return Collections.enumeration(set);
	}

}

class CustomServletInputStream extends ServletInputStream {

	private ByteArrayInputStream bin;

	public CustomServletInputStream(ByteArrayInputStream bin) {
		this.bin = bin;
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setReadListener(ReadListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public int read() throws IOException {
		// TODO Auto-generated method stub
		return bin.read();
	}

}

class BufferResponse extends HttpServletResponseWrapper {

	private ByteArrayOutputStream bout = new ByteArrayOutputStream();
	private PrintWriter pw;
	private HttpServletResponse response;

	public BufferResponse(HttpServletResponse response) {
		super(response);
		this.response = response;
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return new CustomServletOutputStream(bout);
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		pw = new PrintWriter(new OutputStreamWriter(bout, this.response.getCharacterEncoding()));
		return pw;
	}

	public byte[] getBuffer() {
		try {
			if (pw != null) {
				pw.close();
			}
			if (bout != null) {
				bout.flush();
				return bout.toByteArray();
			}

			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

class CustomServletOutputStream extends ServletOutputStream {

	private ByteArrayOutputStream bout;

	public CustomServletOutputStream(ByteArrayOutputStream bout) {
		this.bout = bout;
	}

	@Override
	public void write(int b) throws IOException {
		this.bout.write(b);
	}

	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setWriteListener(WriteListener arg0) {
		// TODO Auto-generated method stub

	}
}
