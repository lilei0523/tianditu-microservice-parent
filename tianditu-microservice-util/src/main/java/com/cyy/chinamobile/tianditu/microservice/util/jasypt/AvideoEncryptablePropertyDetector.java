package com.cyy.chinamobile.tianditu.microservice.util.jasypt;

import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyDetector;

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
