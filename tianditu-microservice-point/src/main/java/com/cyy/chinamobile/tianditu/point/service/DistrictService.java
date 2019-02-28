package com.cyy.chinamobile.tianditu.point.service;

import com.cyy.chinamobile.tianditu.microservice.domain.district.vo.DistrictVo;

import java.util.Map;

/**
 * @author Li lei
 * @date 2019年02月25日 15:34
 */
public interface DistrictService {

    Map<String, Object> getDistrict(DistrictVo params);


}
