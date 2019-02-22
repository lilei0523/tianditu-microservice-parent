package com.cyy.chinamobile.tianditu.microservice.eureka.server.filter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyy.chinamobile.tianditu.microservice.eureka.server.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class UserSecurtyVerfFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(UserSecurtyVerfFilter.class);

    @Autowired
    private UserInfoService userInfoService;


    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        response.setContentType("application/json;charset=UTF-8");
        return true;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public String filterType() {
        return "pre";
    }
}