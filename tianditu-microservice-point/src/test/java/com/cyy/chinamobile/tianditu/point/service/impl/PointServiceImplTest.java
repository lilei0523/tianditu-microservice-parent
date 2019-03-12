package com.cyy.chinamobile.tianditu.point.service.impl;

import com.cyy.chinamobile.tianditu.BaseSpringJUnitTest;
import com.cyy.chinamobile.tianditu.microservice.domain.point.vo.PointVo;
import com.cyy.chinamobile.tianditu.microservice.util.ReturnUtil;
import com.cyy.chinamobile.tianditu.point.service.PointService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Li lei
 * @date 2019年02月27日 17:10
 */
public class PointServiceImplTest extends BaseSpringJUnitTest {

    @Autowired
    private  PointService pointService;

    /*@Test
    public void getAllPoints() throws Exception {
        Map<String, Object> result = pointService.getAllPoints();
        Assert.assertEquals(ReturnUtil.CODE_SUCCESS,result.get(ReturnUtil.RETURN_CODE_NAME));
    }*/

    @Test
    public void addPoint() throws Exception{
        PointVo pointVo = new PointVo();

        pointVo.setName("二医院");
        pointVo.setAddress("遂宁市船山区");
        pointVo.setInternetSite("www.eryiyuan.com");
        pointVo.setPhone("0825-6876999");
        pointVo.setType("0001");
        pointVo.setRegion("船山区");

        Map<String, Object> result = pointService.addPoint(pointVo);
        Assert.assertEquals(ReturnUtil.CODE_SUCCESS, result.get(ReturnUtil.RETURN_CODE_NAME));
    }

    @Test
    public void deletePoint() throws Exception{
        PointVo pointVo = new PointVo();
        List<Integer> idArray = new ArrayList<>();
        idArray.add(8);
        idArray.add(10);
        pointVo.setIds(idArray);

        Map<String, Object> result = pointService.deletePoint(pointVo);
        Assert.assertEquals(ReturnUtil.CODE_FORMAT_ERROR, result.get(ReturnUtil.RETURN_CODE_NAME));

    }

    @Test
    public void updatePoint() throws Exception{
        PointVo pointVo = new PointVo();
        pointVo.setId(9);
        pointVo.setPhone("0825-999666");

        Map<String, Object> result = pointService.updatePoint(pointVo);
        Assert.assertEquals(ReturnUtil.CODE_SUCCESS,result.get(ReturnUtil.RETURN_CODE_NAME));
    }
}