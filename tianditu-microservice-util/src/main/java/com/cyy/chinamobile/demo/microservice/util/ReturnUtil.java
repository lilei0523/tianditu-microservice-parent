package com..chinamobile.demo.microservice.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: ReturnUtil
 * @Description: 统一返回格式
 * @author: 张力
 * @date: 2017年9月25日 上午11:32:45
 */
public class ReturnUtil {
	/* 返回码key */
	public static final String RETURN_CODE_NAME = "code";

	/* 返回提示信息key */
	public static final String RETURN_MSG_NAME = "message";

	/* 返回数据key */
	public static final String RETURN_DETAILS_NAME = "data";

	public static final String RETURN_TOTAL_COUNT = "totalCount";
	/**
	 * 别的数据
	 */
	public static final String RETURN_OTHER_DATA = "otherData";

	public static final Integer CODE_SIGN_ERROR = -1;/* 返回码 鉴权错误 */
	public static final String CODE_SIGN_ERROR_MESSAGE = "签名失败";/* 返回码 鉴权错误 */
	public static final Integer CODE_USER_FREEZE_ERROR = -2; /* 返回码 用户冻结 */
	public static final String CODE_USER_FREEZE_ERROR_MESSAGE = "用户已被冻结";/* 返回码 用户已冻结 */
	public static final Integer CODE_TOKEN_EXPIRED_ERROR = -3; /* 返回码 会话已过期 */
	public static final String CODE_TOKEN_EXPIRED_ERROR_MESSAGE = "会话已过期";/* 返回码 会话已过期 */

	public static final Integer CODE_VERIFY_USER_PRIVILEGE_ERROR = -4; /* 返回码 用户无功能权限 */
	public static final Integer CODE_VERIFY_CODE_ERROR = -5; /* 返回码 验证码错误 */
	public static final Integer CODE_VERIFY_CODE_EXPIRE = -6; /* 返回码 验证码过期 */

	public static final Integer CODE_INTERNAL_ERROR = -100; /* 返回码 内部错误 */
	public static final String CODE_INTERNAL_ERROR_MESSAGE = "服务器更新中，请稍后再试^_^"; /* 返回码 内部错误 */
	public static final Integer CODE_NULL_ERROR = -101; /* 返回码 参数为空错误 */
	public static final Integer CODE_FORMAT_ERROR = -102; /* 返回码 参数格式错误 */
	public static final Integer CODE_NOTEXIST_ERROR = -103; /* 返回码 参数在后台不存在错误 */
	public static final Integer CODE_OPERATE_ERROR = -104; /* 返回码 操作错误 */
	public static final Integer CODE_CLOUD_STORAGE_NOT_EXIST = -110; /* 云回放录像文件不存在或已删除 */

	public static final Integer CODE_HYSTRIX_PROTECT_ERROR = -200; /* 返回码 断路保护错误 */

	public static final Integer CODE_DEVICE_TOKEN_NOT_EXIST_ERROR = -301; /* 返回码 设备未在openapi中注册成功 */
	public static final String CODE_DEVICE_TOKEN_NOT_EXIST_ERROR_MESSAGE = "deviceToken不存在，设备可能未在OpenApi中注册";

	public static final Integer CODE_SUCCESS = 1; /* 返回码 成功 */
	public static final Integer CODE_OTHER_SUCCESS = 2; /* 返回码 成功但可能存在其他问题 */

	/**
	 * 构建返回HashMap
	 *
	 * @param code
	 * @param message
	 * @return
	 */
	public static Map<String, Object> retMap(int code, String message) {
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
	public static Map<String, Object> retMap(int code, String message, Object details) {
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
	public static Map<String, Object> retMap(int code, String message, Object details, Integer totalCount) {
		Map<String, Object> mav = new LinkedHashMap<String, Object>();
		mav.put(RETURN_CODE_NAME, code);
		mav.put(RETURN_MSG_NAME, message);
		mav.put(RETURN_DETAILS_NAME, details);
		mav.put(RETURN_TOTAL_COUNT, totalCount);
		return mav;
	}

	/**
	 * 构建返回HashMap 并带数据
	 *
	 * @param code * @param message  * @param details  * @param map
	 * @date: 上午 9:33 2018/2/7 0007
	 */
	private static Map<String, Object> retMap(Integer code, String message, Object details, Map<String, Object> map) {
		Map<String, Object> mav = new LinkedHashMap<String, Object>();
		mav.put(RETURN_CODE_NAME, code);
		mav.put(RETURN_MSG_NAME, message);
		mav.put(RETURN_DETAILS_NAME, details);
		mav.put(RETURN_OTHER_DATA, map);
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

	/**
	 * 用户功能权限校验失败
	 *
	 * @param message
	 * @return
	 */
	public static Map<String, Object> retMapNoPrivilegeError(String message) {
		return retMap(CODE_VERIFY_USER_PRIVILEGE_ERROR, message);
	}

	/**
	 * 成功带数据
	 *
	 * @param message
	 * @return
	 */
	public static Map<String, Object> retMapSuccess(String message, Object details) {
		return retMap(CODE_SUCCESS, message, details);
	}

	/**
	 * @Title: retMapSuccess @Description: 成功带数据，加总数 @param @param
	 * message @param @param details @param @param totalCount @param @return @return
	 * Map<String,Object> @throws
	 */
	public static Map<String, Object> retMapSuccess(String message, Object details, Integer totalCount) {
		return retMap(CODE_SUCCESS, message, details, totalCount);
	}

	/**
	 * @Title: retMapSuccess @Description: 成功带数据，附加其他数据 @param @param
	 * message @param @param details @param @param totalCount @param @return @return
	 * Map<String,Object> @throws
	 */
	public static Map<String, Object> retMapSuccess(String message, Object details, Map<String, Object> map) {
		return retMap(CODE_SUCCESS, message, details, map);
	}

	/**
	 * 成功带数据
	 *
	 * @param message
	 * @return
	 */
	public static Map<String, Object> retMapSuccess(String message, String keyName, Object details) {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		data.put(keyName, details);
		return retMap(CODE_SUCCESS, message, data);
	}

	/**
	 * 操作错误
	 *
	 * @param message
	 * @param e
	 * @return
	 */
	public static Map<String, Object> retMapOperateError(String message) {
		return retMap(CODE_OPERATE_ERROR, message);
	}

	/**
	 * 参数后台验证码错误
	 *
	 * @param message
	 * @param e
	 * @return
	 */
	public static Map<String, Object> retMapVerifyCodeError(String message) {
		return retMap(CODE_VERIFY_CODE_ERROR, message);
	}

	/**
	 * 参数后台 签名错误
	 *
	 * @param message
	 * @param e
	 * @return
	 */
	public static Map<String, Object> retMapSignError() {
		return retMap(CODE_SIGN_ERROR, CODE_SIGN_ERROR_MESSAGE);
	}

	/**
	 * 参数后台 用户冻结
	 *
	 * @param message
	 * @param e
	 * @return
	 */
	public static Map<String, Object> retMapUserFreezeError() {
		return retMap(CODE_USER_FREEZE_ERROR, CODE_USER_FREEZE_ERROR_MESSAGE);
	}

	/**
	 * 参数后台token超时
	 *
	 * @param message
	 * @param e
	 * @return
	 */
	public static Map<String, Object> retMapTokenExpiredError() {
		return retMap(CODE_TOKEN_EXPIRED_ERROR, CODE_TOKEN_EXPIRED_ERROR_MESSAGE);
	}

	/**
	 * 参数后台不存在错误
	 *
	 * @param message
	 * @param e
	 * @return
	 */
	public static Map<String, Object> retMapNotExistError(String message) {
		return retMap(CODE_NOTEXIST_ERROR, message);
	}

	/**
	 * 参数格式错误
	 *
	 * @param message
	 * @param e
	 * @return
	 */
	public static Map<String, Object> retMapFormatError(String message) {
		return retMap(CODE_FORMAT_ERROR, message);
	}

	/**
	 * 参数格式错误
	 *
	 * @param message
	 * @param e
	 * @return
	 */
	public static Map<String, Object> retMapFormatError(String message, String details) {
		return retMap(CODE_FORMAT_ERROR, message, details);
	}

	/**
	 * 参数为空错误
	 *
	 * @param message
	 * @param e
	 * @return
	 */
	public static Map<String, Object> retMapNullError(String message) {
		return retMap(CODE_NULL_ERROR, message);
	}

	/**
	 * 参数为空错误
	 *
	 * @param message
	 * @param e
	 * @return
	 */
	public static Map<String, Object> retMapNullError(String message, String details) {
		return retMap(CODE_NULL_ERROR, message, details);
	}

	/**
	 * 服务器内部错误
	 *
	 * @param e
	 * @return
	 */
	public static Map<String, Object> retMapInternalError(Exception e) {
		return retMap(CODE_INTERNAL_ERROR, e.getMessage());
	}

	public static Map<String, Object> retBussinessError(Exception e) {
		return retMap(CODE_INTERNAL_ERROR, e.getMessage());
	}

	public static Map<String, Object> retBussinessError(String message) {
		return retMap(CODE_INTERNAL_ERROR, message);
	}

	public static Map<String, Object> retMapInternalError() {
		return retMap(CODE_INTERNAL_ERROR, CODE_INTERNAL_ERROR_MESSAGE);
	}

	public static Map<String, Object> retMapHystrixProtectError(String message) {
		return retMap(CODE_HYSTRIX_PROTECT_ERROR, message);
	}

	public static Map<String, Object> retMapSuccessDetails(String message, Object details) {
		Map<String, Object> ret = retMap(1, message);
		ret.put("details", details);
		return ret;
	}

	/**
	 * @return
	 * @description deviceToken不存在，设备没有在OpenApi中注册
	 */
	public static Map<String, Object> retMapDeviceTokenNotExistError() {
		return retMap(CODE_DEVICE_TOKEN_NOT_EXIST_ERROR, CODE_DEVICE_TOKEN_NOT_EXIST_ERROR_MESSAGE);
	}

}
