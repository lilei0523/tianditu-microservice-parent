package com.cyy.chinamobile.tianditu.point.service.impl;

import com.cyy.chinamobile.tianditu.microservice.domain.point.po.Point;
import com.cyy.chinamobile.tianditu.microservice.domain.point.vo.PointVo;
import com.cyy.chinamobile.tianditu.microservice.util.ReturnUtil;
import com.cyy.chinamobile.tianditu.point.dao.mapper.PointMapper;
import com.cyy.chinamobile.tianditu.point.service.PointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

    @Override
    public Integer addPoint(PointVo point) {
        return pointMapper.addPoint(point);
    }

    @Override
    public Object deletePoint(Map<String ,List<Integer>> ids) {
        List<Integer> ids1 = ids.get("ids");
        logger.info("删除项id："+ids1.toString());
        List<Point> points = pointMapper.selectPointById(ids1);
        if (points.isEmpty()) {
            return ReturnUtil.retMapFormatError("请确认需要删除的项是否存在");
        }
        return pointMapper.deletePoint(ids1);
    }

    @Override
    public Integer updatePoint(PointVo point) {
        return pointMapper.updatePoint(point);
    }
}

