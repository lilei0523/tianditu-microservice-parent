package com.cyy.chinamobile.demo.microservice.domain.exception;

/**
 * 
 * @ClassName: SystemException 
 * @Description: 系统异常(除jdk定义的本系统异常,无需返回给接口调用者)
 * @author: 张力
 * @date: 2017年9月25日 上午10:44:10
 */
public class SystemException extends Exception {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: serialVersionUID 用于序列化,对外透出时有用
	 */
	private static final long serialVersionUID = 1L;

	public SystemException() {
	}

	public SystemException(String message) {
		super(message);
	}

}
