/**
 * ChinaMobile  Inc.
 * Copyright (c) 2010-2018 All Rights Reserved.
 */
package com..chinamobile.demo.microservice.eureka.server.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.cyy.chinamobile.tianditu.microservice.domain.common.BusinessExceptionType;
import com.cyy.chinamobile.tianditu.microservice.domain.exception.BusinessException;
import com.cyy.chinamobile.tianditu.microservice.domain.user.po.UserInfo;
import com..chinamobile.demo.microservice.eureka.server.feign.UserFeignService;
import com..chinamobile.demo.microservice.util.ReturnUtil;
import com..chinamobile.demo.microservice.util.log.LogIdThreadLocal;

/**
 * @author zengzhiqiang
 * @version \$Id: UserInfoService.java, v 0.1 2018-06-02 15:46 zengzhiqiang Exp $$
 */
@Service("userInfoService")
public class UserInfoService {

	private static final Logger logger = LoggerFactory.getLogger(UserInfoService.class);

	// 用户信息缓存
	private Cache<Integer, UserInfo> userCache =  CacheBuilder.newBuilder().maximumSize(1000).expireAfterWrite(1, TimeUnit.HOURS).build(); 
	
	@Autowired
	private UserFeignService userFeignService;
	
}