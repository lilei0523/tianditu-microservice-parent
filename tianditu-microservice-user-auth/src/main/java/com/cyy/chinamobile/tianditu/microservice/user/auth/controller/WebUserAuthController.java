package com.cyy.chinamobile.tianditu.microservice.user.auth.controller;

import java.util.Map;

import com.cyy.chinamobile.tianditu.microservice.domain.base.validatedgroup.UserAuthValidatedGroup;
import com.cyy.chinamobile.tianditu.microservice.user.auth.service.UserService;
import com.cyy.chinamobile.tianditu.microservice.util.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cyy.chinamobile.tianditu.microservice.domain.user.vo.UserInfoVo;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/web")
public class WebUserAuthController {

	@Autowired
	private UserService userService;


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
