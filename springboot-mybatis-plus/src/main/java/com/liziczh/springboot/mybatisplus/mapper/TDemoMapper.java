package com.liziczh.springboot.mybatisplus.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liziczh.springboot.mybatisplus.entity.TDemo;

@Mapper
public interface TDemoMapper  extends BaseMapper<TDemo> {
}