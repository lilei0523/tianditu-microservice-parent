package com.cyy.chinamobile.tianditu.point.controller;

import com.cyy.chinamobile.tianditu.microservice.domain.base.validatedgroup.ValidatedGroup;
import com.cyy.chinamobile.tianditu.microservice.domain.base.validatedgroup.tiandituplatform.PointValidatedGroup;
import com.cyy.chinamobile.tianditu.microservice.domain.point.vo.PointVo;
import com.cyy.chinamobile.tianditu.microservice.util.ReturnUtil;
import com.cyy.chinamobile.tianditu.point.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 关键点controller
 * @author LL
 */
@RestController
@RequestMapping("/web")
public class WebPointController {

    private PointService pointService;

    @Autowired
    WebPointController(PointService pointService) {
        this.pointService = pointService;
    }

    /**
     * 分页查询所有Point列表,根据名称模糊查询
     *
     * @date 14:42 2019/2/25
     */
    @PostMapping(value = "/getAllPoints", produces = "application/json")
    public Map<String, Object> getAllPoints(@Validated(PointValidatedGroup.QueryPointByPageGroup.class)
                                            @RequestBody PointVo pointVo) throws Exception {
        return pointService.getAllPoints(pointVo);
    }

    /**
     * 新增point
     *
     * @author L.L
     * @date 14:43 2019/2/25
     */
    @PostMapping(value = "/addPoint", produces = "application/json")
    public Map<String, Object> addPoint(@Validated(ValidatedGroup.CreateGroup.class)
                                        @RequestBody PointVo point) throws Exception {
        return pointService.addPoint(point);
    }

    /**
     * 删除point
     *
     * @date 14:44 2019/2/25
     */
    @PostMapping(value = "/deletePointByIds", produces = "application/json")
    public Map<String, Object> deletePoint(@Validated(ValidatedGroup.DeleteGroup.class)
                                           @RequestBody PointVo pointVo) throws Exception {

        return pointService.deletePoint(pointVo);
    }

    /**
     * 更新point
     *
     * @date 14:45 2019/2/25
     */
    @PostMapping(value = "/updatePoint", produces = "application/json")
    public Map<String, Object> updatePoint(@Validated(ValidatedGroup.ModifyGroup.class)
                                           @RequestBody PointVo point) throws Exception {
        return pointService.updatePoint(point);
    }

    /**
     * 根据传入的地图坐标信息，查询范围内的point详情
     *
     * @date 10:11 2019/3/6
     */
    @PostMapping(value = "/getPointsByMap", produces = "application/json")
    public Map<String, Object> getPointsByMap(@Validated(ValidatedGroup.QueryGroup.class)
                                              @RequestBody PointVo pointVo) {
        return pointService.getPointsByMap(pointVo);
    }
}
