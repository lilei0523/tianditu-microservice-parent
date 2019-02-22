package com.cyy.chinamobile.tianditu.point.dao.mapper;


import com.cyy.chinamobile.tianditu.microservice.domain.point.po.Point;
import com.cyy.chinamobile.tianditu.microservice.domain.user.po.UserInfo;
import com.cyy.chinamobile.tianditu.microservice.domain.user.vo.UserInfoVo;
import org.springframework.stereotype.Component;

import java.util.List;

public interface PointMapper {

    List<Point> selectAllPoints();
}