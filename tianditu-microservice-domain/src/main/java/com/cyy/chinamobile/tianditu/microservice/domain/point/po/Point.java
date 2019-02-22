package com.cyy.chinamobile.tianditu.microservice.domain.point.po;

import com.cyy.chinamobile.tianditu.microservice.domain.base.validatedgroup.UserAuthValidatedGroup;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
public class Point {

	private Integer id;
	private String name;
    private String address;
    private String phone;
    private String internetSite;
    private String lat;
    private String log;
    private Integer type;
    private String region;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInternetSite() {
        return internetSite;
    }

    public void setInternetSite(String internetSite) {
        this.internetSite = internetSite;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", internetSite='" + internetSite + '\'' +
                ", lat='" + lat + '\'' +
                ", log='" + log + '\'' +
                ", type=" + type +
                ", region='" + region + '\'' +
                '}';
    }
}