package com.cyy.chinamobile.tianditu.point.dao.mapper;


import com.cyy.chinamobile.tianditu.microservice.domain.point.po.Point;
import com.cyy.chinamobile.tianditu.microservice.domain.point.vo.PointVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PointMapper {

    List<Point> selectAllPoints(@Param("point")PointVo pointVo);

    Integer updatePoint(@Param("point") PointVo point);

    Integer addPoint(@Param("point") PointVo point);

    Integer deletePoint(List<Integer> ids);

    List<Point> selectPointById(List<Integer> ids);

    List<Point> getPointsLikeName(String pointName);

    Integer countPoints(@Param("point")PointVo pointVo);

    List<Point> getPointsByMap(Map<String, Object> params);
}