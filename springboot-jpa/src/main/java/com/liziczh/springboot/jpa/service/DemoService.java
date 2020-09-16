package com.liziczh.springboot.jpa.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.liziczh.base.common.service.BaseService;
import com.liziczh.springboot.jpa.condition.JpaCondition;
import com.liziczh.springboot.jpa.entity.TDemo;

public interface DemoService extends BaseService {
	/**
	 * 条件查询
	 * @param condition 条件
	 * @return List<TDemo>
	 * @throws Exception 异常
	 */
	Page<TDemo> selectByCondition(JpaCondition<TDemo> condition) throws Exception;
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
