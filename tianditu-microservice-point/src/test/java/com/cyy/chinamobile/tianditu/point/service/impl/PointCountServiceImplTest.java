package com.cyy.chinamobile.tianditu.point.service.impl;

import com.cyy.chinamobile.tianditu.microservice.util.ReturnUtil;
import com.cyy.chinamobile.tianditu.point.dao.mapper.PointCountMapper;
import com.cyy.chinamobile.tianditu.point.service.PointCountService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Li lei
 * @date 2019年03月04日 17:15
 */
public class PointCountServiceImplTest {

    @Autowired
    private PointCountService pointCountService;

    @Test
    public void testGetPointCounts() {
        Map<String, Object> result = pointCountService.getPointCounts();
        Assert.assertEquals(ReturnUtil.CODE_SUCCESS,result.get(ReturnUtil.RETURN_CODE_NAME));
    }
}