package com.liziczh.springboot.mybatisplus.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.yulichang.base.MPJBaseMapper;
import com.liziczh.springboot.mybatisplus.entity.Student;

@Mapper
public interface StudentMapper extends BaseMapper<Student>, MPJBaseMapper<Student> {
}