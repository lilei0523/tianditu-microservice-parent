package com.cyy.chinamobile.demo.microservice.domain.user.vo;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.cyy.chinamobile.demo.microservice.domain.base.validatedgroup.UserAuthValidatedGroup.FindPwdGroup;
import com.cyy.chinamobile.demo.microservice.domain.base.validatedgroup.UserAuthValidatedGroup.LoginGroup;
import com.cyy.chinamobile.demo.microservice.domain.base.validatedgroup.UserAuthValidatedGroup.ModifyPwdGroup;
import com.cyy.chinamobile.demo.microservice.domain.base.validatedgroup.UserAuthValidatedGroup.RegisterGroup;
import com.cyy.chinamobile.demo.microservice.domain.base.validatedgroup.UserAuthValidatedGroup.SaveHuaWeiDeviceToken;
import com.cyy.chinamobile.demo.microservice.domain.base.validatedgroup.UserAuthValidatedGroup.SendMessageCodeGroup;
import com.cyy.chinamobile.demo.microservice.domain.base.validatedgroup.UserAuthValidatedGroup.VerificationModule;
import com.cyy.chinamobile.demo.microservice.domain.base.validatedgroup.UserAuthValidatedGroup.VerifyExistUser;
import com.cyy.chinamobile.demo.microservice.domain.user.po.UserInfo;

@JsonInclude(Include.NON_NULL)
public class UserInfoVo {

    @NotNull(message = "用户名", groups = {LoginGroup.class})
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}