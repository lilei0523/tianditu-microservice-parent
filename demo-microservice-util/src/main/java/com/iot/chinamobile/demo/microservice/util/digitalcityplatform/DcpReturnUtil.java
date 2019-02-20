package com.iot.chinamobile.demo.microservice.util.digitalcityplatform;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: ReturnUtil
 * @Description: 统一返回格式
 * @author: 张力
 * @date: 2017年9月25日 上午11:32:45
 */
public class DcpReturnUtil {
	/* 返回码key */
	public static final String RETURN_CODE_NAME = "code";

	/* 返回提示信息key */
	public static final String RETURN_MSG_NAME = "message";

	/* 返回数据key */
	public static final String RETURN_DETAILS_NAME = "data";

	public static final String RETURN_TOTAL_COUNT = "totalCount";

	public static final String CODE_SUCCESS = "1"; /* 返回码 成功 */

	/* 返回码 鉴权错误 */
	public static final String CODE_ERROR = "-1";
	/* 返回码 鉴权错误 */
	public static final String CODE_ERROR_MESSAGE = "失败";

	/* 返回码 */
	public static final String CODE_APP_KEY_ERROR = "2";
	public static final String CODE_APP_KEY_ERROR_MESSAGE = "appKey过期或者错误";/* 返回码 鉴权错误 */

	/* 返回码 */
	public static final String CODE_USER_PARAM_ERROR = "3";
	public static final String CODE_USER_PARAM_MESSAGE = "参数错误";/* 返回码 鉴权错误 */

	/* 返回码 */
	public static final String CODE_USER_LOGIN_ERROR = "5";
	public static final String CODE_USER_LOGIN_MESSAGE = "登录用户名或密码错误";/* 返回码 鉴权错误 */

	/**
	 * 构建返回HashMap
	 *
	 * @param code
	 * @param message
	 * @return
	 */
	public static Map<String, Object> retMap(String code, String message) {
		Map<String, Object> mav = new LinkedHashMap<String, Object>();
		mav.put(RETURN_CODE_NAME, code);
		mav.put(RETURN_MSG_NAME, message);
		return mav;
	}

	/**
	 * 构建返回HashMap 并带数据
	 *
	 * @param code
	 * @param message
	 * @param details
	 * @return
	 */
	public static Map<String, Object> retMap(String code, String message, Object details) {
		Map<String, Object> mav = new LinkedHashMap<String, Object>();
		mav.put(RETURN_CODE_NAME, code);
		mav.put(RETURN_MSG_NAME, message);
		mav.put(RETURN_DETAILS_NAME, details);
		return mav;
	}

	/**
	 * 构建返回HashMap 并带数据
	 *
	 * @param code
	 * @param message
	 * @param details
	 * @return
	 */
	public static Map<String, Object> retMap(String code, String message, Object details, Integer totalCount) {
		Map<String, Object> mav = new LinkedHashMap<String, Object>();
		mav.put(RETURN_CODE_NAME, code);
		mav.put(RETURN_MSG_NAME, message);
		mav.put(RETURN_DETAILS_NAME, details);
		mav.put(RETURN_TOTAL_COUNT, totalCount);
		return mav;
	}

	/**
	 * 成功
	 *
	 * @param message
	 * @return
	 */
	public static Map<String, Object> retMapSuccess(String message) {
		return retMap(CODE_SUCCESS, message);
	}

	public static Map<String, Object> retMapSuccess(String message, Object details) {
		return retMap(CODE_SUCCESS, message, details);
	}

	public static Map<String, Object> retMapFail() {
		return retMap(CODE_ERROR, CODE_ERROR_MESSAGE);
	}

	public static Map<String, Object> retMapFail(String message) {
		return retMap(CODE_ERROR, message);
	}

	public static Map<String, Object> retMapAppKeyFail() {
		return retMap(CODE_APP_KEY_ERROR, CODE_APP_KEY_ERROR_MESSAGE);
	}

	public static Map<String, Object> retMapAppKeyFail(String message) {
		return retMap(CODE_APP_KEY_ERROR, message);
	}
	
	public static Map<String, Object> retMapParamFail() {
		return retMap(CODE_USER_PARAM_ERROR, CODE_USER_PARAM_MESSAGE);
	}

	public static Map<String, Object> retMapParamFail(String message) {
		return retMap(CODE_USER_PARAM_ERROR, message);
	}

	public static Map<String, Object> retMapLoginFail() {
		return retMap(CODE_USER_LOGIN_ERROR, CODE_USER_LOGIN_MESSAGE);
	}

	public static Map<String, Object> retMapLoginFail(String message) {
		return retMap(CODE_USER_LOGIN_ERROR, message);
	}
}
