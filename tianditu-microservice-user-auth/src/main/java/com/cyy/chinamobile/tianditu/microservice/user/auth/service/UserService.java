package com..chinamobile.demo.microservice.user.auth.service;

import java.util.Map;

import com.cyy.chinamobile.tianditu.microservice.domain.user.vo.UserInfoVo;

public interface UserService {

    boolean login(UserInfoVo userInfoVo);
}
