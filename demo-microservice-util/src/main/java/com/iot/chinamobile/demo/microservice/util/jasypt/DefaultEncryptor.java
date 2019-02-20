package com.iot.chinamobile.demo.microservice.util.jasypt;


import java.util.UUID;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;


/**
 * 
 * @class : DefaultEncryptor
 * @description : 自定义加密规则
 * @author ：fanmeng
 * @date ：2018年4月28日下午4:38:52
 */

public class DefaultEncryptor implements StringEncryptor {

	private final StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
	private final EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
	
	public DefaultEncryptor(){
		config.setAlgorithm("PBEWithMD5AndDES");   // 加密算法
	    config.setPassword("EbfYk");    // 密匙
	    encryptor.setConfig(config);
	}
	
	// 加密
	@Override
	public String encrypt(String message) {

		// 倒序后生成密文，在加上一组随机字符串作为后缀，生成最终密文
		String prefix = new StringBuffer(message).reverse().toString();
		String uuid = UUID.randomUUID().toString();
		String suffix = uuid.substring(0,uuid.indexOf("-"));
		return encryptor.encrypt(prefix) + suffix;
	}

	// 解密
	@Override
	public String decrypt(String message) {

		message = message.substring(0,(message.length() - 8));
		return new StringBuffer(encryptor.decrypt(message)).reverse().toString();
	}

	
	public static void main(String[] args) {
		DefaultEncryptor defaultEncryptor = new DefaultEncryptor();
		System.out.println("mysql.user: " + defaultEncryptor.encrypt("root"));
		System.out.println("mysql.pass: " + defaultEncryptor.encrypt("123456"));
		System.out.println("mysql.password: " + defaultEncryptor.encrypt("demo@123456"));
		System.out.println("git.user: " + defaultEncryptor.encrypt("zengtao"));
		System.out.println("git.pass: " + defaultEncryptor.encrypt("zengtao"));
		System.out.println(defaultEncryptor.decrypt("Yya5Je2xmMOYGvrav2ydPQ==836807e4"));
	}
}
