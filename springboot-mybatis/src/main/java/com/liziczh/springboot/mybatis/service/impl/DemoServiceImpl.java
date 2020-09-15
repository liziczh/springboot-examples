package com.liziczh.springboot.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<TDemo> selectByCondition(DemoCondition condition) {
		return demoMapper.selectByCondition(condition);
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
