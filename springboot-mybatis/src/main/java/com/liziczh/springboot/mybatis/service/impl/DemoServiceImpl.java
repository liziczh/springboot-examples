package com.liziczh.springboot.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liziczh.base.common.condition.PageCondition;
import com.liziczh.springboot.mybatis.condition.DemoCondition;
import com.liziczh.springboot.mybatis.entity.TDemo;
import com.liziczh.springboot.mybatis.mapper.TDemoMapper;
import com.liziczh.springboot.mybatis.service.DemoService;

import lombok.extern.slf4j.Slf4j;

/**
 * Demo服务
 * @author zhehao.chen
 */
@Slf4j
@Service
public class DemoServiceImpl implements DemoService {
	@Autowired
	private TDemoMapper demoMapper;

	@Override
	public PageInfo<TDemo> selectByCondition(DemoCondition condition) {
		PageCondition pageCondition = condition.getPageCondition();
		PageHelper.startPage(pageCondition.getPageNum(), pageCondition.getPageSize());
		List<TDemo> demoList = demoMapper.selectByCondition(condition);
		PageInfo<TDemo> pageInfo = new PageInfo<>(demoList);
		return pageInfo;
	}
	@Override
	public List<TDemo> getAll() {
		return demoMapper.getAll();
	}
	@Override
	public Integer addDemo(TDemo demo) {
		return demoMapper.insert(demo);
	}
	@Override
	public void updateDemo(TDemo demo) {
		demoMapper.update(demo);
	}
	@Override
	public TDemo getDemo(String id) {
		return demoMapper.get(Integer.valueOf(id));
	}
	@Override
	public void deleteDemo(String id) {
		demoMapper.delete(Integer.valueOf(id));
	}
}
