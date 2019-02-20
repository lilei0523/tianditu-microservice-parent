package com.iot.chinamobile.demo.microservice.user.auth.service;

import java.util.Map;

import com.cyy.chinamobile.demo.microservice.domain.user.vo.UserInfoVo;

public interface UserService {

    boolean login(UserInfoVo userInfoVo);
}
