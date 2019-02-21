package com.cyy.chinamobile.tianditu.microservice.util.common;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @ClassName: ClassUtil   
 * @Description: 类定义工具  
 * @author: zhangli  
 * @date:2018年3月6日 上午9:43:17
 */
public class ClassUtil {

	public static Field[] getAllFields(Object object) {
		Class clazz = object.getClass();
		List<Field> fieldList = new ArrayList<>();
		while (clazz != null) {
			fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
			clazz = clazz.getSuperclass();
		}
		Field[] fields = new Field[fieldList.size()];
		fieldList.toArray(fields);
		return fields;
	}

}
