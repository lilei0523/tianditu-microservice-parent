package com.cyy.chinamobile.tianditu.microservice.user.auth.dao.mapper;

import java.util.List;

import com.cyy.chinamobile.tianditu.microservice.domain.user.po.UserInfo;
import com.cyy.chinamobile.tianditu.microservice.domain.user.vo.UserInfoVo;
import org.springframework.stereotype.Component;

@Component
public interface UserInfoMapper {
    UserInfo selectUserByName(UserInfoVo userInfoVo);
}