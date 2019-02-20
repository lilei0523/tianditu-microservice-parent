package com.cyy.chinamobile.tianditu.microservice.eureka.server.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "demo-microservice-user-auth", fallback = com.cyy.chinamobile.tianditu.microservice.eureka.server.feign.HystrixClientFallback.class)
public interface UserFeignService {

	@RequestMapping(value = "/user/query-user-info-by-cellphone", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	String queryUserInfoByCellphone(String inparams);

	@RequestMapping(value = "/user/query-user-info-by-user-id", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	String queryUserInfoByUserId(String inparams);

}
