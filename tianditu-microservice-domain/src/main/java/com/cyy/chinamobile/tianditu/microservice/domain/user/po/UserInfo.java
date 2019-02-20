package com.cyy.chinamobile.tianditu.microservice.domain.user.po;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.cyy.chinamobile.tianditu.microservice.domain.base.validatedgroup.UserAuthValidatedGroup;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class UserInfo {

	@JsonProperty("")
	@NotNull(message = "用户id(userId)不能为空", groups = { UserAuthValidatedGroup.ModifyPwdGroup.class, UserAuthValidatedGroup.QueryUserInfoByUserId.class,
			UserAuthValidatedGroup.webLoginOutGroup.class, UserAuthValidatedGroup.FindPwd.class, UserAuthValidatedGroup.DeleteUserById.class })
	private Integer id;


    @NotNull(message = "账号不能为空", groups = { UserAuthValidatedGroup.GetSaltGroup.class, UserAuthValidatedGroup.LoginGroup.class, UserAuthValidatedGroup.RegisterGroup.class,
			UserAuthValidatedGroup.FindPwdGroup.class, UserAuthValidatedGroup.SendMessageCodeGroup.class, UserAuthValidatedGroup.webLoginGroup.class, UserAuthValidatedGroup.VerificationModule.class,
			UserAuthValidatedGroup.VerifyExistUser.class })
	// 登录账号
	private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}