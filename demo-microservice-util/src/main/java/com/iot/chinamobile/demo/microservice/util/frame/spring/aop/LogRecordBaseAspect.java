package com.iot.chinamobile.demo.microservice.util.frame.spring.aop;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.javassist.ClassClassPath;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.javassist.Modifier;
import org.apache.ibatis.javassist.bytecode.CodeAttribute;
import org.apache.ibatis.javassist.bytecode.LocalVariableAttribute;
import org.apache.ibatis.javassist.bytecode.MethodInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iot.chinamobile.demo.microservice.util.common.ClassUtil;

/**
 * 
 * @ClassName: LogRecordAspect 
 * @Description: 日志记录切面处理
 * @author: 张力
 * @date: 2017年11月2日 下午3:45:18
 */
@Aspect
public abstract class LogRecordBaseAspect {

	private static final Logger logger = LoggerFactory.getLogger("INTERFACE");

	// 定义切点Pointcut
	@Pointcut("execution(public * com.iot.chinamobile.demo.microservice..*.controller.*Controller.*(..))")
	public void excudeService() {

	}

	@Around("excudeService()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();
		HttpServletResponse response = sra.getResponse();

		// 获取全局Log-Id
		String logId = request.getHeader("log-id");
		if (StringUtils.isNotBlank(logId)) {
			MDC.put("LogId", logId);
		}
		// 获取用户id
		String vAPSign = request.getHeader("V-AP-Sign");
		if (StringUtils.isNotBlank(vAPSign)) {
			MDC.put("userId", vAPSign.split(",", -1)[0]);
		}

		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		Object[] args = pjp.getArgs();

		// 获取设备id
		boolean deviceIdFlag = false;
		for (int i = 0; i < args.length; i++) {
			Field[] fields = ClassUtil.getAllFields(args[i]);
			for (Field field : fields) {

				if ("deviceId".equals(field.getName())) {
					field.setAccessible(true);
					String fieldValue = String.valueOf(field.get(args[i]));
					if (StringUtils.isNotBlank(fieldValue)) {
						MDC.put("deviceId", fieldValue);
						deviceIdFlag = true;
					}
					break;
				}

			}
			if (deviceIdFlag) {
				break;
			}
		}

		String classType = pjp.getTarget().getClass().getName();
		Class<?> clazz = Class.forName(classType);
		String clazzName = clazz.getName();
		String methodName = pjp.getSignature().getName(); // 获取方法名称
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		Class[] argsType = methodSignature.getParameterTypes();
		// 获取参数名称和值
		Map<String, Object> nameAndArgs = this.getFieldsName(this.getClass(), clazzName, methodName, args, argsType);

		// 过滤request,response对象
		Map<String, Object> filterNameAndArgs = new HashMap<String, Object>();
		if (nameAndArgs != null && nameAndArgs.size() > 0) {
			for (Map.Entry<String, Object> entry : nameAndArgs.entrySet()) {
				if (!(entry.getValue() instanceof MultipartFile || entry.getValue() instanceof ServletRequest
						|| entry.getValue() instanceof ServletResponse)) {
					filterNameAndArgs.put(entry.getKey(), entry.getValue());
				}
			}
		}

		ObjectMapper objectMapper = new ObjectMapper();

		Map<String, Object> requestMap = new LinkedHashMap<String, Object>();
		String contentType = request.getContentType();
		requestMap.put("url", url);
		requestMap.put("method", method);
		requestMap.put("contentType", contentType);

		// 从Map中获取

		requestMap.put("methodInParams", filterNameAndArgs);

		logger.info("controller层请求参数:" + objectMapper.writeValueAsString(requestMap));

		// result的值就是被拦截方法的返回值
		Object result = pjp.proceed();

		int status = response.getStatus();
		contentType = response.getContentType();
		long endTime = System.currentTimeMillis();
		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();
		responseMap.put("status", status);
		responseMap.put("methodOutParams", result);
		responseMap.put("intTotalTime", endTime - startTime);
		objectMapper.writeValueAsString(responseMap);
		logger.info("controller层返回参数:" + objectMapper.writeValueAsString(responseMap));
		return result;
	}

	private Map<String, Object> getFieldsName(Class cls, String clazzName, String methodName, Object[] args,
			Class[] argsType) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		ClassPool pool = ClassPool.getDefault();
		ClassClassPath classPath = new ClassClassPath(cls);
		pool.insertClassPath(classPath);

		CtClass cc = pool.get(clazzName);
		List<CtClass> params = new ArrayList<>();
		for (Class argType : argsType) {
			params.add(pool.get(argType.getName()));
		}
		CtMethod cm = cc.getDeclaredMethod(methodName, params.toArray(new CtClass[argsType.length]));
		MethodInfo methodInfo = cm.getMethodInfo();
		CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
		LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
		if (attr == null) {
			return null;
		}
		int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
		for (int i = 0; i < cm.getParameterTypes().length; i++) {
			// paramNames即参数名
			map.put(attr.variableName(i + pos), args[i]);
		}
		return map;
	}

}
