package com.liziczh.springboot.aop.controller;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestController {

    public String hello() {
        return "Hello World";
    }

}
