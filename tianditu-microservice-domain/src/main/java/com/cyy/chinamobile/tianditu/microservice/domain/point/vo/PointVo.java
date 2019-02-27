package com.cyy.chinamobile.tianditu.microservice.domain.point.vo;

import com.cyy.chinamobile.tianditu.microservice.domain.base.validatedgroup.UserAuthValidatedGroup.LoginGroup;
import com.cyy.chinamobile.tianditu.microservice.domain.base.validatedgroup.ValidatedGroup;
import com.cyy.chinamobile.tianditu.microservice.domain.point.po.Point;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
public class PointVo extends Point {

    private Integer id;
    @NotNull(groups = ValidatedGroup.CreateGroup.class,message = "名称不能为空")
    private String name;
    @NotNull(groups = ValidatedGroup.CreateGroup.class,message = "地址不能为空")
    private String address;
    @NotNull(groups = ValidatedGroup.CreateGroup.class,message = "电话不能为空")
    private String phone;
    private String internetSite;
    private String lat;
    private String log;
    @NotNull(groups = ValidatedGroup.CreateGroup.class,message = "类别不能为空")
    private Integer type;
    private String region;

}