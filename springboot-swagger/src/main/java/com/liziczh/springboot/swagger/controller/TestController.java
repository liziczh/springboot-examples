package com.liziczh.springboot.swagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(value = "示例接口", tags = "示例接口")
@Slf4j
@RequestMapping(value = "/test/")
@RestController
public class TestController {

    @ApiOperation(value = "测试接口", notes = "Hello World")
    @GetMapping("hello")
    public String hello() {
        return "Hello World";
    }

}
