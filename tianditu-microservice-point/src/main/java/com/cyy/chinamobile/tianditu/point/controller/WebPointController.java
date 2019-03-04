package com.cyy.chinamobile.tianditu.point.controller;

import com.cyy.chinamobile.tianditu.microservice.domain.base.validatedgroup.ValidatedGroup;
import com.cyy.chinamobile.tianditu.microservice.domain.point.vo.PointVo;
import com.cyy.chinamobile.tianditu.microservice.util.ReturnUtil;
import com.cyy.chinamobile.tianditu.point.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/web")
public class WebPointController {

    @Autowired
    private PointService pointService;

    /**
     * 查询Point列表
     *
     * @date 14:42 2019/2/25
     */
    @GetMapping(value = "/getAllPoints", produces = "application/json")
    public Map<String, Object> getAllPoints() throws Exception {
        return  pointService.getAllPoints();
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
        return  pointService.deletePoint(ids);
    }

    /**
     * 更新point
     *
     * @date 14:45 2019/2/25
     */
    @PostMapping(value = "/updatePoint")
    public Map<String, Object> updatePoint(@Validated(ValidatedGroup.ModifyGroup.class)@RequestBody PointVo point) throws Exception {
        return pointService.updatePoint(point);
    }
}
