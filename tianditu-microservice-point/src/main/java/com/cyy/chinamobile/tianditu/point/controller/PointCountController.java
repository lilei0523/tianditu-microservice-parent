package com.cyy.chinamobile.tianditu.point.controller;

import com.cyy.chinamobile.tianditu.point.service.PointCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Li lei
 * @date 2019年03月01日 11:02
 */
@RestController
@RequestMapping("/pointCount")
public class PointCountController {

    private PointCountService pointCountService;

    @Autowired
    PointCountController(PointCountService pointCountService) {
        this.pointCountService = pointCountService;
    }
    /**
     * @author L.L
     * @date 17:50 2019/2/28
     */
    @GetMapping(value = "/getPointCounts")
    public Map<String, Object> getPointCounts() {
        return pointCountService.getPointCounts();
    }

}
