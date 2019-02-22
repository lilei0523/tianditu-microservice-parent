package com.cyy.chinamobile.tianditu.point.controller;

import com.cyy.chinamobile.tianditu.microservice.util.ReturnUtil;
import com.cyy.chinamobile.tianditu.point.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/web")
public class WebPointController {

	@Autowired
	private PointService pointService;


	@GetMapping(value = "/getAllPoints", produces = "application/json")
	public Map<String, Object> getAllPoints( ) throws Exception {
        return ReturnUtil.retMapSuccess("查询所有关键点成功", pointService.getAllPoints());
	}

}
