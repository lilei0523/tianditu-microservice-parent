package com.cyy.chinamobile.tianditu.point.service;

import com.cyy.chinamobile.tianditu.microservice.domain.district.po.District;
import com.cyy.chinamobile.tianditu.microservice.domain.district.vo.DistrictVo;

import java.util.List;

/**
 * @author Li lei
 * @date 2019年02月25日 15:34
 */
public interface DistrictService {

    List<District> getDistrict(DistrictVo params);


}
