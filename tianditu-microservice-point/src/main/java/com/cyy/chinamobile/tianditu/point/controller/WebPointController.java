package com.cyy.chinamobile.tianditu.point.controller;

import com.cyy.chinamobile.tianditu.microservice.domain.base.validatedgroup.ValidatedGroup;
import com.cyy.chinamobile.tianditu.microservice.domain.point.vo.PointVo;
import com.cyy.chinamobile.tianditu.microservice.util.ReturnUtil;
import com.cyy.chinamobile.tianditu.point.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/web")
public class WebPointController {

    private PointService pointService;

    @Autowired
    WebPointController(PointService pointService) {
        this.pointService = pointService;
    }

    /**
     * 分页查询所有Point列表
     *
     * @date 14:42 2019/2/25
     */
    @PostMapping(value = "/getAllPoints", produces = "application/json")
    public Map<String, Object> getAllPoints(@RequestBody PointVo pointVo) throws Exception {
        return pointService.getAllPoints(pointVo);
    }

    /**
     * 根据名称模糊查询关键点
     *
     * @author L.L
     * @date 17:21 2019/3/5
     */
    @PostMapping(value = "/getPointsLikeName", produces = "application/json")
    public Map<String, Object> getPointsLikeName(@RequestBody PointVo point) throws Exception {
        return pointService.getPointsLikeName(point.getPointName());
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
    public Map<String, Object> deletePoint(@RequestBody Map<String, List<Integer>> ids) throws Exception {
        if (ids.size() <= 0) {
            return ReturnUtil.retMapFormatError("请传递需要删除的项");
        }
        return pointService.deletePoint(ids);
    }

    /**
     * 更新point
     *
     * @date 14:45 2019/2/25
     */
    @PostMapping(value = "/updatePoint")
    public Map<String, Object> updatePoint(@Validated(ValidatedGroup.ModifyGroup.class) @RequestBody PointVo point) throws Exception {
        return pointService.updatePoint(point);
    }
}
