package com.cyy.chinamobile.tianditu.point.service;

import com.cyy.chinamobile.tianditu.microservice.domain.point.po.Point;

import java.util.List;

public interface PointService {


    List<Point> getAllPoints();

    Object addPoint(Point point);

    Object deletePoint(Point point);

    Object updatePoint(Point point);
}
