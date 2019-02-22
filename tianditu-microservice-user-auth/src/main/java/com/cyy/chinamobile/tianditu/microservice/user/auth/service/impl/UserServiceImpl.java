package com.cyy.chinamobile.tianditu.microservice.user.auth.service.impl;

import java.util.Map;

import com.cyy.chinamobile.tianditu.microservice.user.auth.dao.mapper.UserInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyy.chinamobile.tianditu.microservice.domain.user.po.UserInfo;
import com.cyy.chinamobile.tianditu.microservice.domain.user.vo.UserInfoVo;
import com.cyy.chinamobile.tianditu.microservice.user.auth.dao.mapper.UserInfoMapper;
import com.cyy.chinamobile.tianditu.microservice.user.auth.service.UserService;
import com.cyy.chinamobile.tianditu.microservice.util.ReturnUtil;

@Transactional(rollbackFor = Exception.class)
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserInfoMapper userInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public boolean login(UserInfoVo userInfoVo) {
        UserInfo userInfo = userInfoMapper.selectUserByName(userInfoVo);
        logger.info("========={}",userInfo.getName());
        if(userInfo != null){
            return true;
        }else {
            return false;
        }
    }
}
