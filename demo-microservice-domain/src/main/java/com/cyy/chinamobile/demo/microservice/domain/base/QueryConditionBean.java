package com.cyy.chinamobile.demo.microservice.domain.base;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.cyy.chinamobile.demo.microservice.domain.base.validatedgroup.HedgwStreamCloudControlGroup;
import com.cyy.chinamobile.demo.microservice.domain.base.validatedgroup.ValidatedGroup;


public class QueryConditionBean {

	@Min(value = 1, groups = { ValidatedGroup.CreateGroup.class, ValidatedGroup.ModifyGroup.class,
			ValidatedGroup.QueryGroup.class, ValidatedGroup.DeleteGroup.class,
			ValidatedGroup.ConditionedQueryGroup.class }, message="页数最小为1")
	@NotNull(groups = { ValidatedGroup.ConditionedQueryGroup.class}, message="页数不能为空")
	Integer pageNum;

	@Min(value = 1, groups = { ValidatedGroup.CreateGroup.class, ValidatedGroup.ModifyGroup.class,
			ValidatedGroup.QueryGroup.class, ValidatedGroup.DeleteGroup.class,
			ValidatedGroup.ConditionedQueryGroup.class }, message="每页个数最小为1")
	@NotNull(groups = { ValidatedGroup.ConditionedQueryGroup.class, HedgwStreamCloudControlGroup.QueryCloudVideoFiles.class }, message="每页个数不能为空")
	Integer pageSize;

	@Pattern(regexp = "^[A-Za-z0-9_]+$", groups = { ValidatedGroup.CreateGroup.class,
			ValidatedGroup.ModifyGroup.class, ValidatedGroup.QueryGroup.class, ValidatedGroup.DeleteGroup.class,
			ValidatedGroup.ConditionedQueryGroup.class }, message="排序字段名只能是字母数字或下划线的组合")
	// can only have digit, charater and _, whitespace is not allowed
	String orderField;

	@Pattern(regexp = "asc|desc", groups = { ValidatedGroup.CreateGroup.class,
			ValidatedGroup.ModifyGroup.class, ValidatedGroup.QueryGroup.class, ValidatedGroup.DeleteGroup.class,
			ValidatedGroup.ConditionedQueryGroup.class }, message="排序方向只能为asc或desc")
	String orderDirection;

	// public static void main(String[] args) {
	// String str1 = "_ 3d  	s  ga23";
	// Matcher matcher1 = java.util.regex.Pattern.compile(
	// "^[A-Za-z0-9_]+$").matcher(str1);
	// if (matcher1.find()) {
	// System.out.println("yes");
	// System.out.println(matcher1.start());
	// } else {
	// System.out.println("no");
	// }
	// }

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	public Integer getStartIndex() {
		if(null == pageNum || pageSize == null){
			return null;
		}
		return (pageNum - 1) * pageSize;
	}
}
