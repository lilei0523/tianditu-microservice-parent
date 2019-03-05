package com.cyy.chinamobile.tianditu.microservice.domain.pointcount.vo;

import com.cyy.chinamobile.tianditu.microservice.domain.base.validatedgroup.ValidatedGroup;
import com.cyy.chinamobile.tianditu.microservice.domain.pointcount.po.PointCount;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Li lei
 * @date 2019年03月01日 10:49
 */
public class PointCountVo extends PointCount {
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
     * vLat:右上角经度
     */
    @NotNull(groups = {ValidatedGroup.QueryGroup.class},message = "请传入右上角经度")
    private Double vLng;

    /**
     * 关键点类型集合
     */
    @NotNull(groups = {ValidatedGroup.QueryGroup.class},message = "请传入关键点类型")
    private List<Integer> keywords;
}
