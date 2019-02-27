package com.cyy.chinamobile.tianditu.point.dao.mapper;

import com.cyy.chinamobile.tianditu.microservice.domain.district.po.District;

import java.util.List;
import java.util.Map;

/**
 * @author Li lei
 * @date 2019年02月25日 15:33
 */
public interface DistrictMapper {
    List<District> getDistricts(Map<String, Object> params);
}
