package com.liziczh.springboot.jpa.condition;

import java.io.Serializable;
import java.util.List;

import com.liziczh.base.common.condition.PageCondition;
import com.liziczh.base.common.condition.SortCondition;

import lombok.Data;

@Data
public class JpaCondition<T> implements Serializable {
	private static final long serialVersionUID = -7473402179827602416L;
	private T t;
	private PageCondition pageCondition;
	private List<SortCondition> sortConditionList;
}
