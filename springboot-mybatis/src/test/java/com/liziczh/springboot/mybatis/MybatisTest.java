package com.liziczh.springboot.mybatis;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Lists;
import com.liziczh.base.common.condition.SortCondition;
import com.liziczh.base.common.util.JacksonUtils;
import com.liziczh.springboot.mybatis.condition.DemoCondition;
import com.liziczh.springboot.mybatis.constant.Constants;
import com.liziczh.springboot.mybatis.entity.TDemo;
import com.liziczh.springboot.mybatis.mapper.TDemoMapper;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = MybatisApplication.class)
@SpringBootTest
@ActiveProfiles("test")
public class MybatisTest {
	@Autowired
	private TDemoMapper demoMapper;

	@Test
	public void selectByConditionTest() {
		DemoCondition condition = new DemoCondition();
		SortCondition sortCondition1 = new SortCondition("CREATE_TIME", SortCondition.ORDER.DESC.getCode());
		SortCondition sortCondition2 = new SortCondition("UPDATE_TIME", SortCondition.ORDER.DESC.getCode());
		condition.setSortConditionList(Lists.newArrayList(sortCondition1, sortCondition2));
		List<TDemo> demoList = demoMapper.selectByCondition(condition);
		System.out.println(JacksonUtils.toJSONString(demoList));
	}
	@Test
	public void getAllTest() {
		demoMapper.getAll();
	}
	@Test
	public void insertDemoTest() {
		TDemo entity = new TDemo();
		entity.setName("liziczh");
		entity.setCreateTime(new Date());
		entity.setCreateUser("lizi");
		entity.setValid(Constants.COMMON_STATUS.VALID.getCode());
		demoMapper.insert(entity);
	}
	@Test
	public void updateDemoTest() {
		TDemo entity = new TDemo();
		entity.setName("liziczh");
		entity.setUpdateTime(new Date());
		entity.setUpdateUser("lizi");
		demoMapper.update(entity);
	}
	@Test
	public void getDemoTest() {
		demoMapper.get(1);
	}
	@Test
	public void delDemoTest() {
		demoMapper.delete(1);
	}
}
