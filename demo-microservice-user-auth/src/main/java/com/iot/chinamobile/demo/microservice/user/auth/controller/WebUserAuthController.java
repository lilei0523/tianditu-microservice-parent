package com.iot.chinamobile.demo.microservice.user.auth.controller;

import java.util.Map;

import com.cyy.chinamobile.demo.microservice.domain.base.validatedgroup.UserAuthValidatedGroup;
import com.iot.chinamobile.demo.microservice.user.auth.service.UserService;
import com.iot.chinamobile.demo.microservice.util.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyy.chinamobile.demo.microservice.domain.user.vo.UserInfoVo;

/**
 * @author ：fanmeng
 * @class : WebUserAuthController
 * @description : web端控制层
 * @date ：2017年10月13日上午11:42:27
 */

@RestController
@RequestMapping("/web")
public class WebUserAuthController {

	@Autowired
	private UserService userService;


	/**
	 * @param :
	 * @description : 用户登陆
	 * @author : fanmeng
	 * @date : 2017年10月13日上午11:48:07
	 */
	@PostMapping("/user/login")
	public Map<String, Object> login(
		@Validated({UserAuthValidatedGroup.LoginGroup.class}) @RequestBody UserInfoVo userInfoVo) throws Exception {
		if (userService.login(userInfoVo)){
            return ReturnUtil.retMapSuccess("登录成功");
        }else {
            return ReturnUtil.retMapNotExistError("登录失败");
        }
	}


}
