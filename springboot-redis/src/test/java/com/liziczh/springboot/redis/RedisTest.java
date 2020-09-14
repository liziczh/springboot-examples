package com.liziczh.springboot.redis;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liziczh.springboot.redis.service.DemoRedisService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(classes = RedisApplication.class)
@SpringBootTest
@ActiveProfiles("test")
public class RedisTest {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private DemoRedisService demoRedisService;

	@Test
	public void StringRedisTemplateSetTest() {
		stringRedisTemplate.opsForValue().set("key", "value", 1, TimeUnit.HOURS);
	}
	@Test
	public void StringRedisTemplateGetTest() {
		String value = stringRedisTemplate.opsForValue().get("key");
		System.out.println(value);
	}
	@Test
	public void StringRedisTemplateHasTest() {
		Boolean hasKey = stringRedisTemplate.hasKey("key");
		System.out.println(hasKey);
	}
	@Test
	public void StringRedisTemplateDelTest() {
		stringRedisTemplate.delete("key");
	}
}
