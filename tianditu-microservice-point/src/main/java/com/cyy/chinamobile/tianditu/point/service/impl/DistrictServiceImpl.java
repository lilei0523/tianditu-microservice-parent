package com.cyy.chinamobile.tianditu.point.service.impl;

import com.cyy.chinamobile.tianditu.microservice.domain.district.vo.DistrictVo;
import com.cyy.chinamobile.tianditu.microservice.util.ReturnUtil;
import com.cyy.chinamobile.tianditu.microservice.util.common.PointConstant;
import com.cyy.chinamobile.tianditu.point.dao.mapper.DistrictMapper;
import com.cyy.chinamobile.tianditu.point.service.DistrictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Li lei
 * @date 2019年02月25日 15:34
 */
@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictMapper districtMapper;

    private static final Logger logger = LoggerFactory.getLogger(DistrictServiceImpl.class);

    @Override
    public Map<String, Object>getDistrict(DistrictVo districtVo) {

        Map<String, Object> params = new HashMap<>();
        // 页面返回code、district
        params.put(PointConstant.CODE, districtVo.getCode() != null ? districtVo.getCode() : PointConstant.NULL);
        params.put(PointConstant.DISTRICT, districtVo.getDistrict() != null ? districtVo.getDistrict() : PointConstant.NULL);
        params.put(PointConstant.PROVINCE_CODE, PointConstant.PROVINCE.equals(districtVo.getDistrict()) ? districtVo.getCode() : PointConstant.NULL);
        params.put(PointConstant.CITY_CODE, PointConstant.CITY.equals(districtVo.getDistrict()) ? districtVo.getCode() : PointConstant.NULL);
        params.put(PointConstant.AREA_CODE, PointConstant.AREA.equals(districtVo.getDistrict()) ? districtVo.getCode() : PointConstant.NULL);
        params.put(PointConstant.STREET_CODE, PointConstant.STREET.equals(districtVo.getDistrict()) ? districtVo.getCode() : PointConstant.NULL);

        logger.info(params.toString());
        return ReturnUtil.retMapSuccess("查询" + params.get(PointConstant.DISTRICT) + "成功", districtMapper.getDistricts(params));
    }
}
