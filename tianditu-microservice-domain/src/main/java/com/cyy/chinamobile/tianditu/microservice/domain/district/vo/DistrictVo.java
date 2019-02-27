package com.cyy.chinamobile.tianditu.microservice.domain.district.vo;

import com.cyy.chinamobile.tianditu.microservice.domain.district.po.District;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Li lei
 * @date 2019年02月25日 15:24
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DistrictVo extends District {
    private String district;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "DistrictVo{" +
                "district='" + district + '\'' +
                '}';
    }
}
