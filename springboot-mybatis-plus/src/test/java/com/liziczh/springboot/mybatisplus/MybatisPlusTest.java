package com.liziczh.springboot.mybatisplus;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liziczh.springboot.mybatisplus.entity.TDemo;
import com.liziczh.springboot.mybatisplus.mapper.TDemoMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusTest {
    @Autowired
    private TDemoMapper demoMapper;

    @Test
    public void insertTest() {
        TDemo entity = new TDemo();
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
        int result = demoMapper.insert(entity);
        Assert.assertEquals(1, result);
    }

    @Test
    public void updateTest() {
        TDemo entity = new TDemo();
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
        int result = demoMapper.updateById(entity);
        Assert.assertEquals(1, result);
    }

    @Test
    public void getTest() {
        TDemo tDemo = demoMapper.selectById(0L);
        Assert.assertNotNull(tDemo);
        Assert.assertEquals(0L, (long) tDemo.getId());
    }

    @Test
    public void selectByConditionTest() {
        QueryWrapper<TDemo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(TDemo::getName, "")
                .ge(TDemo::getCreateTime, "2022-01-01 00:00:00")
                .lt(TDemo::getCreateTime, "2025-01-01 00:00:00");
        Page<TDemo> demoPage = demoMapper.selectPage(new Page<>(1, 10), queryWrapper);
        Assert.assertNotNull(demoPage);
    }

    @Test
    public void delTest() {
        int result = demoMapper.deleteById(0L);
        Assert.assertEquals(1, result);
    }
}
