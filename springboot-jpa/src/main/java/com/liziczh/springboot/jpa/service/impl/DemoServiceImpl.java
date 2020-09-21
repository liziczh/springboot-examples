package com.liziczh.springboot.jpa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.liziczh.base.common.condition.PageCondition;
import com.liziczh.base.common.condition.SortCondition;
import com.liziczh.springboot.jpa.condition.JpaCondition;
import com.liziczh.springboot.jpa.entity.TDemo;
import com.liziczh.springboot.jpa.repository.TDemoRepository;
import com.liziczh.springboot.jpa.service.DemoService;

import lombok.extern.slf4j.Slf4j;

/**
 * Demo服务
 * @author zhehao.chen
 */
@Slf4j
@Service
public class DemoServiceImpl implements DemoService {
	@Autowired
	private TDemoRepository demoRepository;

	@Override
	public Page<TDemo> selectByCondition(JpaCondition<TDemo> condition) {
		PageCondition pageCondition = condition.getPageCondition();
		List<SortCondition> sortConditionList = condition.getSortConditionList();
		List<Sort.Order> sortOrderList = new ArrayList<>();
		sortConditionList.forEach(sortCondition -> {
			Sort.Direction direction = Sort.Direction.DESC;
			if (sortCondition.getOrderType().equals(SortCondition.ORDER.DESC.getCode())) {
				direction = Sort.Direction.DESC;
			} else if (sortCondition.getOrderType().equals(SortCondition.ORDER.ASC.getCode())) {
				direction = Sort.Direction.ASC;
			}
			sortOrderList.add(new Sort.Order(direction, sortCondition.getColumnName()));
		});
		PageRequest page = PageRequest.of(pageCondition.getPageNum(), pageCondition.getPageSize(), Sort.by(sortOrderList));
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("NAME", ExampleMatcher.GenericPropertyMatchers.contains());
		Example<TDemo> example = Example.of(condition.getT(), matcher);
		return demoRepository.findAll(example, page);
	}
	@Override
	public List<TDemo> getAll() {
		return demoRepository.findAll();
	}
	@Override
	public Integer addDemo(TDemo demo) {
		TDemo tDemo = demoRepository.save(demo);
		return tDemo.getId();
	}
	@Override
	public void updateDemo(TDemo demo) {
		demoRepository.save(demo);
	}
	@Override
	public TDemo getDemo(String id) {
		return demoRepository.findById(Integer.valueOf(id)).orElse(null);
	}
	@Override
	public void deleteDemo(String id) {
		demoRepository.deleteById(Integer.valueOf(id));
	}
}
