package com.liziczh.springboot.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.liziczh.springboot.mybatis.condition.DemoCondition;
import com.liziczh.springboot.mybatis.entity.Student;

@Mapper
public interface StudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student row);

    int insertSelective(Student row);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student row);

    int updateByPrimaryKey(Student row);

    List<Student> selectByCondition(DemoCondition condition);
}