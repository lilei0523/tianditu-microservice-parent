package com.cyy.chinamobile.tianditu.point.controller;

import com.cyy.chinamobile.tianditu.microservice.domain.district.vo.DistrictVo;
import com.cyy.chinamobile.tianditu.point.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Li lei
 * @date 2019年02月25日 15:32
 */
@RestController
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    private DistrictService districtService;


    /**
     * 查询district
     *
     * @date 15:52 2019/2/25
     */
    @PostMapping(value = "/getDistricts", produces = "application/json")
    public Map<String, Object> getDistrict(@RequestBody DistrictVo districtVo) throws Exception {
        return  districtService.getDistrict(districtVo);
    }
}
