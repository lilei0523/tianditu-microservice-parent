package com.cyy.chinamobile.tianditu.microservice.domain.point.vo;

import com.cyy.chinamobile.tianditu.microservice.domain.base.validatedgroup.UserAuthValidatedGroup.LoginGroup;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
public class PointVo {

    @NotNull(message = "用户名", groups = {LoginGroup.class})
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}