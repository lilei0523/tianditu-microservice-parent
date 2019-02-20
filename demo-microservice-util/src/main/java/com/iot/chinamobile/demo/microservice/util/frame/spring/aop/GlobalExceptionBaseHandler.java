package com.iot.chinamobile.demo.microservice.util.frame.spring.aop;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.iot.chinamobile.demo.microservice.util.ReturnUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyy.chinamobile.demo.microservice.domain.common.CodeConstants;
import com.cyy.chinamobile.demo.microservice.domain.exception.BusinessException;
import com.cyy.chinamobile.demo.microservice.domain.exception.SystemException;

/**
 * @ClassName: GlobalExceptionHandler
 * @Description: 统一异常处理
 * @author: 张力
 * @date: 2017年9月25日 上午10:43:32
 */

public abstract class GlobalExceptionBaseHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionBaseHandler.class);

	private static Map<String, String> BadRequestMap = null;

	static {
		BadRequestMap = new HashMap<String, String>();
		BadRequestMap.put("returnCode", "-101");
		BadRequestMap.put("returnMsg", "传入参数错误");
	}

	@Value("${spring.profiles.active}")
	private String springProfilesActive;

	@ExceptionHandler(value = { org.springframework.http.converter.HttpMessageNotReadableException.class })
	@ResponseBody
	public Map<String, Object> httpInputExceptionHander(HttpServletRequest request,
			HttpMessageNotReadableException exception) {
		return ReturnUtil.retMapFormatError("传入参数json格式解析错误");
	}

	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	@ResponseBody
	public Map<String, Object> methodArgumentNotValidHandler(HttpServletRequest request,
			MethodArgumentNotValidException exception) throws Exception {
		// 解析原错误信息，封装后返回，此处返回非法的字段名称，原始值，错误信息
		Map<String, Object> retMap = new HashMap<String, Object>(BadRequestMap);
		FieldError error = exception.getBindingResult().getFieldErrors().get(0);
		if (error != null) {
			if (error.getCode().indexOf("NotNull") != -1) {
				return ReturnUtil.retMapNullError(error.getDefaultMessage(),
						error.getField() + "(" + error.getRejectedValue() + ")");
			} else {
				return ReturnUtil.retMapFormatError(error.getDefaultMessage(),
						error.getField() + "(" + error.getRejectedValue() + ")");
			}
		}
		return retMap;
	}

	@ExceptionHandler(value = { BusinessException.class })
	@ResponseBody
	public Map<String, Object> businessExceptionHander(HttpServletRequest request,
			BusinessException businessException) {
		logger.error(businessException.getMessage(), businessException);
		if (CodeConstants.env_conf.DEV.equals(springProfilesActive)) {
			return ReturnUtil.retBussinessError(businessException.getExceptionCode() + businessException.getMessage());
		} else {
			return ReturnUtil.retBussinessError(businessException);
		}
	}

	@ExceptionHandler(value = { SystemException.class })
	@ResponseBody
	public Map<String, Object> systemExceptionHander(HttpServletRequest request, SystemException systemException) {
		logger.error(systemException.getMessage(), systemException);
		if (CodeConstants.env_conf.DEV.equals(springProfilesActive)) {
			return ReturnUtil.retMapInternalError(systemException);
		} else {
			return ReturnUtil.retMapInternalError();
		}
	}

	@ExceptionHandler(value = { Exception.class })
	@ResponseBody
	public Map<String, Object> exceptionHander(HttpServletRequest request, Exception exception) {
		exception.printStackTrace();
		logger.error(exception.getMessage(), exception);
		return ReturnUtil.retMapInternalError();
	}

	@ExceptionHandler(value = { Throwable.class })
	@ResponseBody
	public Map<String, Object> throwableHander(HttpServletRequest request, Throwable throwable) {
		throwable.printStackTrace();
		logger.error(throwable.getMessage(), throwable);
		return ReturnUtil.retMapInternalError();
	}
}
