package com.cyy.chinamobile.tianditu.point.service.impl;

import com.cyy.chinamobile.tianditu.microservice.domain.pointcount.po.PointCount;
import com.cyy.chinamobile.tianditu.microservice.util.ReturnUtil;
import com.cyy.chinamobile.tianditu.point.dao.mapper.PointCountMapper;
import com.cyy.chinamobile.tianditu.point.service.PointCountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Li lei
 * @date 2019年03月01日 11:06
 */
@Service
public class PointCountServiceImpl implements PointCountService {

    private Logger logger = LoggerFactory.getLogger(PointCountServiceImpl.class);
    private PointCountMapper pointCountMapper;

    @Autowired
    PointCountServiceImpl(PointCountMapper pointCountMapper) {
        this.pointCountMapper = pointCountMapper;
    }

    @Override
    public Map<String, Object> getPointCounts() {

        // 查询所有省的数据信息
        List<PointCount> allProvincePointCounts = pointCountMapper.getAllProvincePointCounts();
        // 查询所有市的数据信息
        List<PointCount> allCityPointCounts = pointCountMapper.getAllCityPointCounts();
        // 查询所以区的数据信息
        List<PointCount> allAreaPointCounts = pointCountMapper.getAllAreaPointCounts();

        // 封装返回数据
        long startTime = System.currentTimeMillis();

        List<Map<String, Object>> provinceList = new ArrayList<>();

        // 遍历省数据
        for (PointCount provinceData : allProvincePointCounts) {

            Map<String, Object> provinceMap = new HashMap<>();
            provinceMap.put("name", provinceData.getName());
            provinceMap.put("provinceCode", provinceData.getCode());
            provinceMap.put("count", provinceData.getCountGeneralHospital());
            provinceMap.put("lon", provinceData.getLon());
            provinceMap.put("lat", provinceData.getLat());

            // 创建省下面对应的市信息list
            List<Map<String, Object>> cityList = new ArrayList<>();

            for (PointCount cityData : allCityPointCounts) {
                // 判断市是否是属于该省
                if (cityData.getProvinceCode().equals(provinceData.getCode())) {
                    Map<String, Object> cityMap = new HashMap<>();
                    cityMap.put("name", cityData.getName());
                    cityMap.put("cityCode", cityData.getCode());
                    cityMap.put("count", cityData.getCountGeneralHospital());
                    cityMap.put("lon", cityData.getLon());
                    cityMap.put("lat", cityData.getLat());

                    // 创建市下面对应的区信息list
                    List<Map<String, Object>> areaList = new ArrayList<>();

                    for (PointCount areaData : allAreaPointCounts) {
                        // 判断区是否属于对应的市及省
                        if (areaData.getProvinceCode().equals(provinceData.getCode()) && areaData.getCityCode().equals(cityData.getCode())) {
                            Map<String, Object> areaMap = new HashMap<>();
                            areaMap.put("name", areaData.getName());
                            areaMap.put("areaCode", areaData.getCode());
                            areaMap.put("count", areaData.getCountGeneralHospital());
                            areaMap.put("lon", areaData.getLon());
                            areaMap.put("lat", areaData.getLat());
                            areaList.add(areaMap);
                        }
                    }
                    cityMap.put("areaData", areaList);
                    cityList.add(cityMap);
                }
            }
            provinceMap.put("cityData", cityList);
            provinceList.add(provinceMap);
        }
        long endTime = System.currentTimeMillis();
        logger.info("封装数据耗时：" + (endTime - startTime));

        return ReturnUtil.retMapSuccess("查询成功", provinceList);
    }
}
