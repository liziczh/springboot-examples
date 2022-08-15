package com.liziczh.springboot.redis;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Test
    public void set() {
        redisTemplate.opsForValue().set("test", "test redis...", 60, TimeUnit.SECONDS);
    }

    @Test
    public void hasKey() {
        Boolean result = redisTemplate.hasKey("test");
        log.info("hasKey, result={}", result);
    }

    @Test
    public void getKey() {
        Serializable result = redisTemplate.opsForValue().get("test");
        log.info("getKey, result={}", result);
    }

    @Test
    public void delete() {
        Boolean result = redisTemplate.delete("test");
        log.info("delete, result={}", result);
    }


    @Test
    public void lock() {
        Boolean result = redisTemplate.opsForValue().setIfAbsent("test", 1, 60, TimeUnit.SECONDS);
        log.info("lock, result={}", result);
    }


}
