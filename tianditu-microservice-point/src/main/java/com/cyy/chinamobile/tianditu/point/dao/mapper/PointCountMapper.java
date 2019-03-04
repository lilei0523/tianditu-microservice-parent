package com.cyy.chinamobile.tianditu.point.dao.mapper;

import com.cyy.chinamobile.tianditu.microservice.domain.pointcount.po.PointCount;

import java.util.List;

/**
 * @author Li lei
 * @date 2019年03月01日 11:08
 */
public interface PointCountMapper {
    List<PointCount> getPointCounts(PointCount pointCount);

    List<PointCount> getAllProvincePointCounts();

    List<PointCount> getAllCityPointCounts();
    List<PointCount> getAllAreaPointCounts();

}
