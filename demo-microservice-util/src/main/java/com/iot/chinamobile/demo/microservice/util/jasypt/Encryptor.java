package com.iot.chinamobile.demo.microservice.util.jasypt;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.context.annotation.Bean;

import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyDetector;

/**
 * 
 * @class : Encryptor
 * @description : jasypt配置
 * @author ：fanmeng
 * @date ：2018年4月28日下午5:38:13
 */
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
