package com.iot.chinamobile.demo.microservice.util.feign.andfamily.inside;

import com.cyy.chinamobile.demo.microservice.domain.user.po.UserInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 
 * @ClassName: UserFeignParentService   
 * @Description: 用户微服务feign接口  
 * @author: zhangli  
 * @date:2018年7月5日 上午9:01:05
 */
public interface UserFeignParentService {
	/**
	 * 
	 * @Title: queryUserInfoByUserId   
	 * @Description: 通过userId获取用户信息  
	 * @param @param userInfo
	 * @param @return  
	 * @return String  
	 * @throws
	 */
	@RequestMapping(value = "/user/query-user-info-by-user-id", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	String queryUserInfoByUserId(UserInfo userInfo);

	/**
	 * 
	 * @Title: queryUserInfoByCellphone   
	 * @Description: 通过手机号码获取用户信息  
	 * @param @param userInfo
	 * @param @return  
	 * @return String  
	 * @throws
	 */
	@RequestMapping(value = "/user/query-user-info-by-cellphone", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	String queryUserInfoByCellphone(UserInfo userInfo);


}
