package com.liziczh.springboot.mybatisplus.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liziczh.springboot.mybatisplus.condition.DemoCondition;
import com.liziczh.springboot.mybatisplus.entity.TDemo;

public interface DemoService extends IService<TDemo> {
	/**
	 * 分页查询
	 * @param condition 条件
	 * @return List<TDemo>
	 * @throws Exception 异常
	 */
	Page<TDemo> selectPage(DemoCondition condition) throws Exception;
	/**
	 * 条件查询
	 * @param condition 条件
	 * @return List<TDemo>
	 * @throws Exception 异常
	 */
	List<TDemo> selectByCondition(DemoCondition condition) throws Exception;
	/**
	 * 新增实体
	 * @param demo 实体
	 * @return pk
	 * @throws Exception
	 */
	Integer addDemo(TDemo demo) throws Exception;
	/**
	 * 更新实体
	 * @param demo 实体
	 * @throws Exception 异常
	 */
	void updateDemo(TDemo demo) throws Exception;
	/**
	 * 查询单个实体
	 * @param id id
	 * @return TDemo
	 * @throws Exception 异常
	 */
	TDemo getDemo(String id) throws Exception;
	/**
	 * 删除实体
	 * @param id id
	 * @throws Exception 异常
	 */
	void deleteDemo(String id) throws Exception;
}
