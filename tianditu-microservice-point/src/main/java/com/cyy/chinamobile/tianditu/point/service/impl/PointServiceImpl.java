package com.cyy.chinamobile.tianditu.point.service.impl;

import com.cyy.chinamobile.tianditu.microservice.domain.common.PageBean;
import com.cyy.chinamobile.tianditu.microservice.domain.point.po.Point;
import com.cyy.chinamobile.tianditu.microservice.domain.point.vo.PointVo;
import com.cyy.chinamobile.tianditu.microservice.util.ReturnUtil;
import com.cyy.chinamobile.tianditu.point.dao.mapper.PointMapper;
import com.cyy.chinamobile.tianditu.point.service.PointService;
import com.github.pagehelper.PageHelper;
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
    public Map<String, Object> getAllPoints(PointVo pointVo) {
        // 设置分页信息
        if (pointVo.getCurrentPage() != null && pointVo.getPageSize() != null) {
            PageHelper.startPage(pointVo.getCurrentPage(), pointVo.getPageSize());
        }
        // 查询所有point
        List<Point> allPoints = pointMapper.selectAllPoints();

        if (pointVo.getCurrentPage() != null && pointVo.getPageSize() != null) {
            // 构建pageData
            PageBean<Point> pageData = new PageBean<>(pointVo.getCurrentPage(), pointVo.getPageSize(), allPoints.size());
            pageData.setItems(allPoints);
            // 返回分页数据
            return ReturnUtil.retMapSuccess("查询所有关键点成功", pageData.getItems());
        }
        // 返回所有数据
        return ReturnUtil.retMapSuccess("查询所有关键点成功", allPoints);
    }

    @Override
    public Map<String, Object> addPoint(PointVo point) {
        return ReturnUtil.retMapSuccess("新增关键点成功", pointMapper.addPoint(point));
    }

    @Override
    public Map<String, Object> deletePoint(Map<String, List<Integer>> ids) {
        List<Integer> ids1 = ids.get("ids");
        logger.info("删除项id：" + ids1.toString());
        List<Point> points = pointMapper.selectPointById(ids1);
        if (points.isEmpty()) {
            return ReturnUtil.retMapFormatError("请确认需要删除的项是否存在");
        }
        return ReturnUtil.retMapSuccess("删除成功", pointMapper.deletePoint(ids1));
    }

    @Override
    public Map<String, Object> updatePoint(PointVo point) {
        return ReturnUtil.retMapSuccess("更新关键点成功", pointMapper.updatePoint(point));
    }

    @Override
    public Map<String, Object> getPointsLikeName(String pointName) {
        return ReturnUtil.retMapSuccess("根据名称模糊查询成功", pointMapper.getPointsLikeName(pointName));
    }
}

