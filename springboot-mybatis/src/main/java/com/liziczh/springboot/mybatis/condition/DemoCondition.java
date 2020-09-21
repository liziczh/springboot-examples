package com.liziczh.springboot.mybatis.condition;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.liziczh.base.common.condition.PageCondition;
import com.liziczh.base.common.condition.SortCondition;

import lombok.Data;

@Data
public class DemoCondition implements Serializable {
	private static final long serialVersionUID = -7473402179827602416L;
	private String name;
	private Date startTime;
	private Date endTime;
	private String valid;
	private PageCondition pageCondition;
	private List<SortCondition> sortConditionList;
}
