package com.cyy.chinamobile.tianditu.microservice.domain.point.vo;

import com.cyy.chinamobile.tianditu.microservice.domain.point.po.Point;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PointVo extends Point {

    private String pointName;
    private Integer currentPage ;
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

}