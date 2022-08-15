package com.liziczh.springboot.redis.util;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/8/15 4:12 PM
 */
@Slf4j
@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    public String getKey(String key) {
        return String.valueOf(redisTemplate.opsForValue().get(key));
    }

    public Boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    public void set(String key, Serializable value, Integer expireSeconds) {
        redisTemplate.opsForValue().set(key, value, expireSeconds, TimeUnit.SECONDS);
    }

    public Boolean lock(String key, Integer expireSeconds) {
        return redisTemplate.opsForValue().setIfAbsent(key, 1, expireSeconds, TimeUnit.SECONDS);
    }

}
