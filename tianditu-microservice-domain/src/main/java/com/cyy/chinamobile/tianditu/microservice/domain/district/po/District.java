package com.cyy.chinamobile.tianditu.microservice.domain.district.po;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Li lei
 * @date 2019年02月25日 15:21
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class District {

    private Long code;
    /**
     * 名称
     */
    private String name;
    private Long streetCode;
    /**
     * 省code
     */
    private Integer provinceCode;
    /**
     * 市code
     */
    private Integer cityCode;
    /**
     * 区code
     */
    private Integer areaCode;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(Long streetCode) {
        this.streetCode = streetCode;
    }

    public Integer getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
    }

    public Integer getCityCode() {
        return cityCode;
    }

    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    @Override
    public String toString() {
        return "District{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", streetCode=" + streetCode +
                ", provinceCode=" + provinceCode +
                ", cityCode=" + cityCode +
                ", areaCode=" + areaCode +
                '}';
    }
}
