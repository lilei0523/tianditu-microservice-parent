package com.cyy.chinamobile.tianditu.point.service.impl;

import com.cyy.chinamobile.tianditu.BaseSpringJUnitTest;
import com.cyy.chinamobile.tianditu.microservice.domain.district.vo.DistrictVo;
import com.cyy.chinamobile.tianditu.microservice.util.ReturnUtil;
import com.cyy.chinamobile.tianditu.point.service.DistrictService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author Li lei
 * @date 2019年02月27日 16:54
 */
public class DistrictServiceImplTest extends BaseSpringJUnitTest {

    @Autowired
    private DistrictService districtService;

    @Test
    public void testGetDistrict() {

        DistrictVo params = new DistrictVo();
        params.setDistrict(null);
        params.setCode(null);
        Map<String, Object> result = districtService.getDistrict(params);
        Assert.assertEquals(1, result.get(ReturnUtil.RETURN_CODE_NAME));
    }
}