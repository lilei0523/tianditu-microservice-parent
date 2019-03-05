package com.cyy.chinamobile.tianditu.point.service;

import com.cyy.chinamobile.tianditu.microservice.domain.point.vo.PointVo;

import java.util.List;
import java.util.Map;

public interface PointService {


    Map<String, Object> getAllPoints(PointVo pointVo) throws Exception;

    Map<String, Object> addPoint(PointVo point) throws Exception;

    Map<String, Object> deletePoint(Map<String, List<Integer>> ids) throws Exception;

    Map<String, Object> updatePoint(PointVo point) throws Exception;

    Map<String, Object> getPointsLikeName(String pointName);
}
