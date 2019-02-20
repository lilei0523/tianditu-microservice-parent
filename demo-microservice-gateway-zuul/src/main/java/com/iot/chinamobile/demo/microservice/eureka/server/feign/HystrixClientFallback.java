package com.iot.chinamobile.demo.microservice.eureka.server.feign;

import org.springframework.stereotype.Component;

/**
 * 断路器功能，服务不可用时的默认路径
 */
@Component
class HystrixClientFallback implements UserFeignService {

	@Override
	public String queryUserInfoByCellphone(String inparams) {
		// TODO 断路器应该返回服务不可用
		return null;
	}

	@Override
	public String queryUserInfoByUserId(String inparams) {
		// TODO 断路器应该返回服务不可用
		return null;
	}

}