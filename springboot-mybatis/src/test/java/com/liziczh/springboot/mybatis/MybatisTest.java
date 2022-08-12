package com.liziczh.springboot.mybatis;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.liziczh.springboot.mybatis.condition.DemoCondition;
import com.liziczh.springboot.mybatis.entity.TDemo;
import com.liziczh.springboot.mybatis.mapper.TDemoMapper;

@RunWith(SpringRunner.class)
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
        int result = demoMapper.updateByPrimaryKeySelective(entity);
        Assert.assertEquals(1, result);
    }

    @Test
    public void getTest() {
        TDemo tDemo = demoMapper.selectByPrimaryKey(0L);
        Assert.assertNotNull(tDemo);
        Assert.assertEquals(0L, (long) tDemo.getId());
    }

    @Test
    public void selectByConditionTest() {
        DemoCondition condition = new DemoCondition();
        List<TDemo> demoList = demoMapper.selectByCondition(condition);
        Assert.assertNotNull(demoList);
        Assert.assertEquals(0L, (long) demoList.get(0).getId());
    }

    @Test
    public void delTest() {
        int result = demoMapper.deleteByPrimaryKey(0L);
        Assert.assertEquals(1, result);
    }
}
