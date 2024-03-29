package com.liziczh.springboot.swagger.controller;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liziczh.springboot.swagger.api.dto.DemoDTO;

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

    @ApiOperation(value = "保存接口", notes = "Hello World")
    @PostMapping("save")
    public String save(@RequestBody DemoDTO dto) {
        log.info("dto={}", dto);
        return "success";
    }

    @ApiOperation(value = "查询接口", notes = "Hello World")
    @GetMapping("get/{id}")
    public DemoDTO get(@PathVariable Long id) {
        DemoDTO dto = new DemoDTO();
        dto.setId(id);
        dto.setCreateTime(new Date());
        dto.setCreateUser("");
        dto.setUpdateTime(new Date());
        dto.setUpdateUser("");
        dto.setVersion(0);
        dto.setIsDel(0);
        dto.setDemoId(0L);
        dto.setName("abc");
        dto.setDesc("zxc");
        return dto;
    }

}
