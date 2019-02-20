package com.cyy.chinamobile.demo.microservice.domain.exception;

import com.cyy.chinamobile.demo.microservice.domain.common.BusinessExceptionType;

/**
 * 
 * @ClassName: BusinessException 
 * @Description: 业务异常(需返回异常描述给接口调用者,前端展示给用户的业务操作提示)
 * @author: 张力
 * @date: 2017年9月25日 上午10:44:10
 */
public class BusinessException extends Exception {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: serialVersionUID 用于序列化,对外透出时有用
	 */
	private static final long serialVersionUID = 1L;

	private String exceptionCode;

	public BusinessException() {
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(BusinessExceptionType businessExceptionType) {
		super(businessExceptionType.getValue());
		this.exceptionCode = businessExceptionType.getKey();
	}

	public BusinessException(BusinessExceptionType businessExceptionType, String message) {
		super(message);
		this.exceptionCode = businessExceptionType.getKey();
	}

	public String getExceptionCode() {
		return this.exceptionCode;
	}

	public static void main(String[] args) {
		System.out.println(new BusinessException(BusinessExceptionType.NULL_ARGUMENT, "userID不能为空").getExceptionCode());
		System.out.println(BusinessExceptionType.CLOUD_STORAFE_NOT_EXIST.getKey());
	}

}
