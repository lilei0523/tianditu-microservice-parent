package com.cyy.chinamobile.tianditu.microservice.util.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @ClassName: CommonUtil   
 * @Description: 常用工具类  
 * @author: zhangli  
 * @date:2018年3月9日 下午4:11:50
 */
public class CommonUtil {

	/**
	 * 
	 * @Title: UnixTimeStampToDate   
	 * @Description: Java将Unix时间戳转换成指定格式日期字符串  
	 * @param @param UnixTimeStampToDate
	 * @param @param formats
	 * @param @return  
	 * @return String  
	 * @throws
	 */
	public static String unixTimeStampToDate(long timestamp, String formats) {
		if (StringUtils.isBlank(formats)){
			formats = "yyyy-MM-dd HH:mm:ss";
		}
		timestamp = timestamp * 1000;
		String date = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
		return date;
	}

}
