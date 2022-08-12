package com.liziczh.springboot.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.liziczh.springboot.mybatis.condition.DemoCondition;
import com.liziczh.springboot.mybatis.entity.TDemo;

@Mapper
public interface TDemoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TDemo row);

    int insertSelective(TDemo row);

    TDemo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TDemo row);

    int updateByPrimaryKey(TDemo row);

    List<TDemo> selectByCondition(DemoCondition condition);
}