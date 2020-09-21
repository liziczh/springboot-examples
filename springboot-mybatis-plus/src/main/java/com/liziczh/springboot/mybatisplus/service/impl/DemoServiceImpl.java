package com.liziczh.springboot.mybatisplus.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liziczh.base.common.condition.PageCondition;
import com.liziczh.base.common.condition.SortCondition;
import com.liziczh.springboot.mybatisplus.condition.DemoCondition;
import com.liziczh.springboot.mybatisplus.constant.Constants;
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
		List<SortCondition> sortConditionList = condition.getSortConditionList();
		QueryWrapper<TDemo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().like(TDemo::getName, condition.getName()).lt(TDemo::getCreateTime, new Date()).eq(TDemo::getValid, Constants.COMMON_STATUS.VALID.getCode());
		return demoMapper.selectPage(new Page<>(pageCondition.getPageNum(), pageCondition.getPageSize()), queryWrapper);
	}
	@Override
	public List<TDemo> selectByCondition(DemoCondition condition) {
		PageCondition pageCondition = condition.getPageCondition();
		List<SortCondition> sortConditionList = condition.getSortConditionList();
		QueryWrapper<TDemo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().like(TDemo::getName, condition.getName()).lt(TDemo::getCreateTime, new Date()).eq(TDemo::getValid, Constants.COMMON_STATUS.VALID.getCode());
		return demoMapper.selectList(queryWrapper);
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
