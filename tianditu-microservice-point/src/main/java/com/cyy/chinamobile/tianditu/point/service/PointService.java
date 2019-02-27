package com.cyy.chinamobile.tianditu.point.service;

import com.cyy.chinamobile.tianditu.microservice.domain.point.po.Point;
import com.cyy.chinamobile.tianditu.microservice.domain.point.vo.PointVo;

import java.util.List;
import java.util.Map;

public interface PointService {


    List<Point> getAllPoints() throws Exception;

    Integer addPoint(PointVo point) throws Exception;

    Object deletePoint(Map<String,List<Integer>> ids) throws Exception;

    Integer updatePoint(Point point) throws Exception;
}
