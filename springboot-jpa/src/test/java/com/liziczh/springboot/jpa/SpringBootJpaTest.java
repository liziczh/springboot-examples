package com.liziczh.springboot.jpa;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.liziczh.springboot.jpa.entity.TDemo;
import com.liziczh.springboot.jpa.repository.TDemoRepository;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = SpringDataJpaApplication.class)
@SpringBootTest
@ActiveProfiles("test")
public class SpringBootJpaTest {
	@Autowired
	private TDemoRepository tDemoRepository;

	@Test
	public void findTest() {
		tDemoRepository.findAll();
	}
	@Test
	public void saveTest() {
		TDemo tDemo = new TDemo();
		tDemo.setName("lizi");
		tDemo.setCreateTime(new Date());
		tDemo.setCreateUser("zhehao.chen");
		tDemoRepository.save(tDemo);
	}
}
