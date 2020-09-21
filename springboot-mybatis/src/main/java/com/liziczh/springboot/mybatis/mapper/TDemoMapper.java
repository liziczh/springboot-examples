package com.liziczh.springboot.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.liziczh.base.common.repository.BaseRepository;
import com.liziczh.springboot.mybatis.condition.DemoCondition;
import com.liziczh.springboot.mybatis.entity.TDemo;

@Mapper
public interface TDemoMapper extends BaseRepository<TDemo, Integer, DemoCondition> {
}
