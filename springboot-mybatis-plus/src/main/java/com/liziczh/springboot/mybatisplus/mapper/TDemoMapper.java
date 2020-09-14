package com.liziczh.springboot.mybatisplus.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.liziczh.archetype.api.condition.DemoCondition;
import com.liziczh.archetype.api.entity.TDemo;
import com.liziczh.base.common.repository.BaseRepository;

@Repository
@Mapper
public interface TDemoMapper extends BaseRepository<TDemo, Integer, DemoCondition> {
}
