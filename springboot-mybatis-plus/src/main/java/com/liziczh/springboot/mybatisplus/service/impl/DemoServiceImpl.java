package com.liziczh.springboot.mybatisplus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liziczh.base.common.condition.PageCondition;
import com.liziczh.springboot.mybatisplus.condition.DemoCondition;
import com.liziczh.springboot.mybatisplus.entity.TDemo;
import com.liziczh.springboot.mybatisplus.mapper.TDemoMapper;
import com.liziczh.springboot.mybatisplus.service.DemoService;

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
	public Page<TDemo> selectPage(DemoCondition condition) {
		PageCondition pageCondition = condition.getPageCondition();
		TDemo demoCondition = new TDemo();
		demoCondition.setName("栗子");
		return demoMapper.selectPage(new Page<>(pageCondition.getPageNum(), pageCondition.getPageSize()), new QueryWrapper<>(demoCondition));
	}
	@Override
	public List<TDemo> selectByCondition(DemoCondition condition) {
		TDemo demo = new TDemo();
		demo.setName("栗子");
		return demoMapper.selectList(new QueryWrapper<>(demo));
	}
	@Override
	public Integer addDemo(TDemo demo) {
		demoMapper.insert(demo);
		return demo.getId();
	}
	@Override
	public void updateDemo(TDemo demo) {
		demoMapper.updateById(demo);
	}
	@Override
	public TDemo getDemo(String id) {
		return demoMapper.selectById(Integer.valueOf(id));
	}
	@Override
	public void deleteDemo(String id) {
		demoMapper.deleteById(Integer.valueOf(id));
	}
}
