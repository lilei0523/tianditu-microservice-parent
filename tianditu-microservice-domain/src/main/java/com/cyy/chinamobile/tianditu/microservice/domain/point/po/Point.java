package com.cyy.chinamobile.tianditu.microservice.domain.point.po;

import com.cyy.chinamobile.tianditu.microservice.domain.base.validatedgroup.ValidatedGroup;
import com.cyy.chinamobile.tianditu.microservice.domain.common.CodeConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
public class Point {

    @NotNull(groups = ValidatedGroup.ModifyGroup.class, message = "id不能为空")
    private Integer id;
    @NotNull(groups = ValidatedGroup.CreateGroup.class, message = "名称不能为空")
    private String name;
    @NotNull(groups = ValidatedGroup.CreateGroup.class, message = "地址不能为空")
    private String address;
    @NotNull(groups = ValidatedGroup.CreateGroup.class, message = "电话不能为空")
    private String phone;
    private String internetSite;
    private String localSiteName;
    private String lat;
    private String log;
    @NotNull(groups = ValidatedGroup.CreateGroup.class, message = "类别不能为空")
    private String type;
    /**
     * 是否是三甲医院，0:不是，1：是
     */
    private Byte isTopThreeHospital = 0;
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

    public String getLocalSiteName() {
        return localSiteName;
    }

    public void setLocalSiteName(String localSiteName) {
        // 拼接URL
        if (localSiteName == null) {
            this.localSiteName = localSiteName;
        } else {
            this.localSiteName = CodeConstants.SYSTEM_INTER_CONSTATNTS.LOCAL_SITE_URL + localSiteName + CodeConstants.SYSTEM_INTER_CONSTATNTS.HTML;
        }
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

    public String getType() {
        return type;
    }

    public Byte getIsTopThreeHospital() {
        return isTopThreeHospital;
    }

    public void setIsTopThreeHospital(Byte isTopThreeHospital) {
        this.isTopThreeHospital = isTopThreeHospital;
    }

    public void setType(String type) {
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
                ", localSiteName='" + localSiteName + '\'' +
                ", lat='" + lat + '\'' +
                ", log='" + log + '\'' +
                ", type='" + type + '\'' +
                ", isTopThreeHospital=" + isTopThreeHospital +
                ", region='" + region + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Point point = new Point();
        point.setLocalSiteName("a");
        System.out.println(point.getLocalSiteName());
    }
}