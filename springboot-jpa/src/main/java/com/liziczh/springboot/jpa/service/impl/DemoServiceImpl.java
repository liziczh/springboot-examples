package com.liziczh.springboot.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<TDemo> selectByCondition(String name) {
		return demoRepository.findByName(name);
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
