package com.iot.chinamobile.demo.microservice.user.auth.dao.mapper;

import java.util.List;

import com.cyy.chinamobile.demo.microservice.domain.user.po.UserInfo;
import com.cyy.chinamobile.demo.microservice.domain.user.vo.UserInfoVo;

public interface UserInfoMapper {
    UserInfo selectUserByName(UserInfoVo userInfoVo);
}