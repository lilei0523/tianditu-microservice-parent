package com.cyy.chinamobile.tianditu.point.service.impl;

import com.cyy.chinamobile.tianditu.microservice.domain.point.po.Point;
import com.cyy.chinamobile.tianditu.point.dao.mapper.PointMapper;
import com.cyy.chinamobile.tianditu.point.service.PointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
public class PointServiceImpl implements PointService {

	@Autowired
	private PointMapper pointMapper;

    private static final Logger logger = LoggerFactory.getLogger(PointServiceImpl.class);


    @Override
    public List<Point> getAllPoints() {
        return pointMapper.selectAllPoints();
    }
}
