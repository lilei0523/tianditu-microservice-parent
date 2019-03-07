package com.cyy.chinamobile.tianditu.microservice.domain.point.vo;

import com.cyy.chinamobile.tianditu.microservice.domain.base.validatedgroup.ValidatedGroup;
import com.cyy.chinamobile.tianditu.microservice.domain.base.validatedgroup.tiandituplatform.PointValidatedGroup;
import com.cyy.chinamobile.tianditu.microservice.domain.point.po.Point;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.validation.constraints.NotNull;
import java.util.List;

@JsonInclude(Include.NON_NULL)
public class PointVo extends Point {

    /**
     * mLat:左下角纬度
     */
    @NotNull(groups = {ValidatedGroup.QueryGroup.class},message = "请传入左下角纬度")
    private Double mLat;

    /**
     * mLng:左下角经度
     */
    @NotNull(groups = {ValidatedGroup.QueryGroup.class},message = "请传入左下角经度")
    private Double mLng;

    /**
     * vLat:右上角纬度
     */
    @NotNull(groups = {ValidatedGroup.QueryGroup.class},message = "请传入右上角纬度")
    private Double vLat;

    /**
     * vLng:右上角经度
     */
    @NotNull(groups = {ValidatedGroup.QueryGroup.class},message = "请传入右上角经度")
    private Double vLng;

    /**
     * 关键点类型集合
     */
    @NotNull(groups = {ValidatedGroup.QueryGroup.class},message = "请传入关键点类型")
    private List<String> types;

    private String pointName;
    @NotNull(groups = {PointValidatedGroup.QueryPointByPageGroup.class},message = "请传递当前页")
    private Integer currentPage ;
    @NotNull(groups = {PointValidatedGroup.QueryPointByPageGroup.class},message = "请传递每页显示记录数")
    private Integer pageSize ;

    public String getPointName() {
        return pointName;
    }


    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Double getmLat() {
        return mLat;
    }

    public void setmLat(Double mLat) {
        this.mLat = mLat;
    }

    public Double getmLng() {
        return mLng;
    }

    public void setmLng(Double mLng) {
        this.mLng = mLng;
    }

    public Double getvLat() {
        return vLat;
    }

    public void setvLat(Double vLat) {
        this.vLat = vLat;
    }

    public Double getvLng() {
        return vLng;
    }

    public void setvLng(Double vLng) {
        this.vLng = vLng;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "PointVo{" +
                "mLat=" + mLat +
                ", mLng=" + mLng +
                ", vLat=" + vLat +
                ", vLng=" + vLng +
                ", types=" + types +
                ", pointName='" + pointName + '\'' +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}