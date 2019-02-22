package com.cyy.chinamobile.tianditu.point.dao.mapper;


import com.cyy.chinamobile.tianditu.microservice.domain.point.po.Point;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PointMapper {

    List<Point> selectAllPoints();

    int updatePoint(@Param("point")Point point);

    int addPoint(@Param("point") Point point);

    int deletePoint(@Param("point") Point point);
}