package com.liziczh.springboot.mybatis.service;

import java.util.List;

import com.liziczh.base.common.service.BaseService;
import com.liziczh.springboot.mybatis.condition.DemoCondition;
import com.liziczh.springboot.mybatis.entity.TDemo;

public interface DemoService extends BaseService {
	/**
	 * 条件查询
	 * @param condition 条件
	 * @return List<TDemo>
	 * @throws Exception 异常
	 */
	List<TDemo> selectByCondition(DemoCondition condition) throws Exception;
	/**
	 * 查询全部
	 * @return TDemo
	 * @throws Exception 异常
	 */
	List<TDemo> getAll() throws Exception;
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
