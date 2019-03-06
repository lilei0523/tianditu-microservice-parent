package com.cyy.chinamobile.tianditu.point.service.impl;

import com.cyy.chinamobile.tianditu.microservice.domain.common.CodeConstants;
import com.cyy.chinamobile.tianditu.microservice.domain.district.vo.DistrictVo;
import com.cyy.chinamobile.tianditu.microservice.util.ReturnUtil;
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
        params.put(CodeConstants.SYSTEM_INTER_CONSTATNTS.CODE, districtVo.getCode() != null ? districtVo.getCode() : CodeConstants.SYSTEM_INTER_CONSTATNTS.NULL);
        params.put(CodeConstants.SYSTEM_INTER_CONSTATNTS.DISTRICT, districtVo.getDistrict() != null ? districtVo.getDistrict() : CodeConstants.SYSTEM_INTER_CONSTATNTS.NULL);
        params.put(CodeConstants.SYSTEM_INTER_CONSTATNTS.PROVINCE_CODE, CodeConstants.SYSTEM_INTER_CONSTATNTS.PROVINCE.equals(districtVo.getDistrict()) ? districtVo.getCode() : CodeConstants.SYSTEM_INTER_CONSTATNTS.NULL);
        params.put(CodeConstants.SYSTEM_INTER_CONSTATNTS.CITY_CODE, CodeConstants.SYSTEM_INTER_CONSTATNTS.CITY.equals(districtVo.getDistrict()) ? districtVo.getCode() : CodeConstants.SYSTEM_INTER_CONSTATNTS.NULL);
        params.put(CodeConstants.SYSTEM_INTER_CONSTATNTS.AREA_CODE, CodeConstants.SYSTEM_INTER_CONSTATNTS.AREA.equals(districtVo.getDistrict()) ? districtVo.getCode() : CodeConstants.SYSTEM_INTER_CONSTATNTS.NULL);
        params.put(CodeConstants.SYSTEM_INTER_CONSTATNTS.STREET_CODE, CodeConstants.SYSTEM_INTER_CONSTATNTS.STREET.equals(districtVo.getDistrict()) ? districtVo.getCode() : CodeConstants.SYSTEM_INTER_CONSTATNTS.NULL);

        logger.info(params.toString());
        return ReturnUtil.retMapSuccess("查询" + params.get(CodeConstants.SYSTEM_INTER_CONSTATNTS.DISTRICT) + "成功", districtMapper.getDistricts(params));
    }
}
