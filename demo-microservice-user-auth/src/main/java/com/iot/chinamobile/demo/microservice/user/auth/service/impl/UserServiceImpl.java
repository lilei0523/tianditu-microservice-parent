package com.iot.chinamobile.demo.microservice.user.auth.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyy.chinamobile.demo.microservice.domain.user.po.UserInfo;
import com.cyy.chinamobile.demo.microservice.domain.user.vo.UserInfoVo;
import com.iot.chinamobile.demo.microservice.user.auth.dao.mapper.UserInfoMapper;
import com.iot.chinamobile.demo.microservice.user.auth.service.UserService;
import com.iot.chinamobile.demo.microservice.util.ReturnUtil;

@Transactional(rollbackFor = Exception.class)
@Service("userCommonService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserInfoMapper userInfoMapper;


    @Override
    public boolean login(UserInfoVo userInfoVo) {
        UserInfo userInfo = userInfoMapper.selectUserByName(userInfoVo);
        if(userInfo != null){
            return true;
        }else {
            return false;
        }
    }
}
