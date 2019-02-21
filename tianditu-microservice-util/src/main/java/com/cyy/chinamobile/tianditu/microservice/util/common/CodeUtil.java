package com.cyy.chinamobile.tianditu.microservice.util.common;

import java.security.SecureRandom;
import java.util.Random;

import sun.misc.BASE64Encoder;

public class CodeUtil {

	/**
	 * 
	 * @Title: getSalt 
	 * @Description: 获取盐值
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	public static String getSalt() throws Exception {
		Random random = new SecureRandom();
		byte[] salt = new byte[8];
		random.nextBytes(salt);
		String str = new BASE64Encoder().encode(salt);
		return str;
	}

	/**
	 * 
	 * @Title: getMessageCode 
	 * @Description: 获取num位随机码
	 * @return
	 * @return: String
	 */
	public static String getRandomCode(int num) {
		StringBuffer digitDivisor = new StringBuffer("1");
		for (int i = 1; i < num; i++) {
			digitDivisor.append("0");
		}
		return Integer.toString((int) ((Math.random() * 9 + 1) * Integer.parseInt(digitDivisor.toString())));

	}

}
