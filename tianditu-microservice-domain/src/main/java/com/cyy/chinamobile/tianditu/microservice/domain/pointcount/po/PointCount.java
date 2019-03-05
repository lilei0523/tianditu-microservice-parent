package com.cyy.chinamobile.tianditu.microservice.domain.pointcount.po;

/**
 * @author Li lei
 * @date 2019年03月01日 10:44
 */
public class PointCount {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 编码
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 辖区范围内的综合医院数量
     */
    private Integer countGeneralHospital;
    /**
     * 辖区范围内的专科医院数量
     */
    private Integer countSpecialistHospital;

    /**
     * 省编码
     */
    private String provinceCode;
    private String provinceName;
    /**
     * 市编码
     */
    private String cityCode;
    private String cityName;

    /**
     * 经度
     */
    private Double lat;
    /**
     * 纬度
     */
    private Double lon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }


    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Integer getCountGeneralHospital() {
        return countGeneralHospital;
    }

    public void setCountGeneralHospital(Integer countGeneralHospital) {
        this.countGeneralHospital = countGeneralHospital;
    }

    public Integer getCountSpecialistHospital() {
        return countSpecialistHospital;
    }

    public void setCountSpecialistHospital(Integer countSpecialistHospital) {
        this.countSpecialistHospital = countSpecialistHospital;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityname) {
        this.cityName = cityname;
    }

    @Override
    public String toString() {
        return "PointCount{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", countGeneralHospital=" + countGeneralHospital +
                ", countSpecialistHospital=" + countSpecialistHospital +
                ", provinceCode='" + provinceCode + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
