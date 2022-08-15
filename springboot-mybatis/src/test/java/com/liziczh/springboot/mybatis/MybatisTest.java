package com.liziczh.springboot.mybatis;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.liziczh.springboot.mybatis.condition.DemoCondition;
import com.liziczh.springboot.mybatis.entity.TDemo;
import com.liziczh.springboot.mybatis.mapper.TDemoMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MybatisTest {
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
        int result = demoMapper.insertSelective(entity);
        log.info("result={}", result);
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
        int result = demoMapper.updateByPrimaryKeySelective(entity);
    }

    @Test
    public void getTest() {
        TDemo tDemo = demoMapper.selectByPrimaryKey(0L);
    }

    @Test
    public void selectByConditionTest() {
        DemoCondition condition = new DemoCondition();
        List<TDemo> demoList = demoMapper.selectByCondition(condition);
    }

    @Test
    public void delTest() {
        int result = demoMapper.deleteByPrimaryKey(0L);
    }
}
