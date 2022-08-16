package com.liziczh.springboot.redis;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.liziczh.springboot.redis.dto.DemoDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

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
        String result = String.valueOf(redisTemplate.opsForValue().get("test"));
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

    @Test
    public void saveDTO() {
        DemoDTO dto = new DemoDTO();
        dto.setId(0L);
        dto.setCreateTime(new Date());
        dto.setCreateUser("");
        dto.setUpdateTime(new Date());
        dto.setUpdateUser("");
        dto.setVersion(0);
        dto.setIsDel(0);
        dto.setDemoId(0L);
        dto.setName("");
        dto.setDesc("");
        redisTemplate.opsForValue().set("test", dto, 60, TimeUnit.SECONDS);
        String result = String.valueOf(redisTemplate.opsForValue().get("test"));
        log.info("saveDTO, dto={}", result);
    }

}
