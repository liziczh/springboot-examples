package com.liziczh.springboot.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.liziczh.base.common.repository.BaseRepository;
import com.liziczh.springboot.mybatis.condition.DemoCondition;
import com.liziczh.springboot.mybatis.entity.TDemo;

@Repository
@Mapper
public interface TDemoMapper extends BaseRepository<TDemo, Integer, DemoCondition> {
}
