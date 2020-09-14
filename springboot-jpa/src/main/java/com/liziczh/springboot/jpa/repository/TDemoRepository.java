package com.liziczh.springboot.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liziczh.springboot.jpa.entity.TDemo;

public interface TDemoRepository extends JpaRepository<TDemo, Integer> {
	/**
	 * 根据姓名查询记录
	 * @param name 姓名
	 * @return 记录
	 */
	List<TDemo> findByName(String name);
}
