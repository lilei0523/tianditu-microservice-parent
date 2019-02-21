package com.cyy.chinamobile.tianditu.microservice.util.jasypt;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.context.annotation.Bean;

import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyDetector;

public abstract class Encryptor {

	@Bean(name = "jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
		return new DefaultEncryptor();
    }
	
	@Bean(name = "encryptablePropertyDetector")
	public EncryptablePropertyDetector encryptablePropertyDetector(){
		return new AvideoEncryptablePropertyDetector();
	}
}
