package com.liziczh.springboot.mybatis;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.liziczh.springboot.mybatis.condition.DemoCondition;
import com.liziczh.springboot.mybatis.entity.Student;
import com.liziczh.springboot.mybatis.mapper.StudentMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {
    @Autowired
    private StudentMapper demoMapper;

    @Test
    public void insertTest() {
        Student entity = new Student();
        entity.setId(0L);
        entity.setCreateTime(new Date());
        entity.setCreateUser("");
        entity.setUpdateTime(new Date());
        entity.setUpdateUser("");
        entity.setVersion(0);
        entity.setIsDel(0);
        entity.setDemoId(0L);
        entity.setName("liziczh");
        entity.setDesc("liziczh");
        int result = demoMapper.insertSelective(entity);
        log.info("result={}", result);
    }

    @Test
    public void updateTest() {
        Student entity = new Student();
        entity.setId(0L);
        entity.setCreateTime(new Date());
        entity.setCreateUser("");
        entity.setUpdateTime(new Date());
        entity.setUpdateUser("");
        entity.setVersion(0);
        entity.setIsDel(0);
        entity.setDemoId(0L);
        entity.setName("liziczh2");
        entity.setDesc("liziczh2");
        int result = demoMapper.updateByPrimaryKeySelective(entity);
    }

    @Test
    public void getTest() {
        Student tDemo = demoMapper.selectByPrimaryKey(0L);
    }

    @Test
    public void selectByConditionTest() {
        DemoCondition condition = new DemoCondition();
        List<Student> demoList = demoMapper.selectByCondition(condition);
    }

    @Test
    public void delTest() {
        int result = demoMapper.deleteByPrimaryKey(0L);
    }
}
