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

import com.liziczh.archetype.api.common.Constants;
import com.liziczh.archetype.api.condition.DemoCondition;
import com.liziczh.archetype.api.entity.TDemo;
import com.liziczh.springboot.mybatis.mapper.TDemoMapper;
import com.liziczh.base.common.condition.SortCondition;

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
		SortCondition sortCondition = new SortCondition("CREATE_TIME", SortCondition.ORDER.DESC.getCode());
		condition.setSortCondition(sortCondition);
		List<TDemo> demoList = demoMapper.selectByCondition(condition);
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
