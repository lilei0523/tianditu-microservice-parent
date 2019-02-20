package com.cyy.chinamobile.demo.microservice.domain.base;

public class ReturnInfoBase {
	
	private String errorCode;
	private String description;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
