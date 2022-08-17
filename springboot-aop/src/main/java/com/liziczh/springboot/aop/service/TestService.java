package com.liziczh.springboot.aop.service;

import org.springframework.stereotype.Component;

import com.liziczh.springboot.aop.annotation.AppService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestService {

    @AppService
    public String hello() {
        return "Hello World";
    }

}
