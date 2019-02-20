package com..chinamobile.demo.microservice.util.jasypt;

import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyDetector;

/**
 * 
 * @class : AvideoEncryptablePropertyDetector
 * @description : 自定义jasypt标识前后缀
 * @author ：fanmeng
 * @date ：2018年5月2日下午3:11:23
 */
public class AvideoEncryptablePropertyDetector implements EncryptablePropertyDetector{

	private final String PREFIX = "DEMO(";
	private final String SUFFIX = ")";
	@Override
	public boolean isEncrypted(String property) {

		if(property == null){
			return false;	
		}
		final String value = property.trim();
		return(value.startsWith(PREFIX) && value.endsWith(SUFFIX));
	}

	@Override
	public String unwrapEncryptedValue(String property) {

		return property.substring(PREFIX.length(),(property.length() - SUFFIX.length()));
	}

	
}
