package com.liziczh.springboot.easyexcel;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(classes = SpringbootEasyexcelApplication.class)
@SpringBootTest
@ActiveProfiles("test")
public class SpringbootEasyexcelApplicationTests {
	@Test
	void contextLoads() {
	}
}
