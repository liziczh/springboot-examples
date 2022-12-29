package com.liziczh.springboot.mybatisplus;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liziczh.springboot.mybatisplus.entity.Student;
import com.liziczh.springboot.mybatisplus.mapper.StudentMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusTest {
    @Autowired
    private StudentMapper demoMapper;

    @Test
    public void insertTest() {
        Student entity = new Student();
        entity.setId(0L);
        entity.setCreateTime(LocalDateTime.now());
        entity.setCreateUser("");
        entity.setUpdateTime(LocalDateTime.now());
        entity.setUpdateUser("");
        entity.setVersion(0);
        entity.setIsDel(0);
        entity.setStudentId(0L);
        entity.setName("liziczh");
        entity.setDesc("liziczh");
        int result = demoMapper.insert(entity);
        Assert.assertEquals(1, result);
    }

    @Test
    public void updateTest() {
        Student entity = new Student();
        entity.setId(0L);
        entity.setCreateTime(LocalDateTime.now());
        entity.setCreateUser("");
        entity.setUpdateTime(LocalDateTime.now());
        entity.setUpdateUser("");
        entity.setVersion(0);
        entity.setIsDel(0);
        entity.setStudentId(0L);
        entity.setName("liziczh2");
        entity.setDesc("liziczh2");
        int result = demoMapper.updateById(entity);
        Assert.assertEquals(1, result);
    }

    @Test
    public void getTest() {
        Student tDemo = demoMapper.selectById(0L);
        Assert.assertNotNull(tDemo);
        Assert.assertEquals(0L, (long) tDemo.getId());
    }

    @Test
    public void selectByConditionTest() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(Student::getName, "")
            .ge(Student::getCreateTime, "2022-01-01 00:00:00")
            .lt(Student::getCreateTime, "2025-01-01 00:00:00");
        Page<Student> demoPage = demoMapper.selectPage(new Page<>(1, 10), queryWrapper);
        Assert.assertNotNull(demoPage);
    }

    @Test
    public void delTest() {
        int result = demoMapper.deleteById(0L);
        Assert.assertEquals(1, result);
    }
}
