package com.liziczh.springboot.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liziczh.base.common.result.Result;
import com.liziczh.base.common.result.ResultBuilder;
import com.liziczh.springboot.redis.service.DemoRedisService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "示例接口", tags = "示例接口")
@RequestMapping(value = "/demo/")
@RestController
public class DemoRedisController {
	@Autowired
	private DemoRedisService demoRedisService;

	@ApiOperation(value = "缓存", notes = "缓存")
	@PostMapping(value = "/cache/{key}/{value}")
	public Result<String> cache(@PathVariable String key, @PathVariable String value) throws Exception {
		demoRedisService.setValue(key, value);
		return new ResultBuilder<String>().success();
	}
	@ApiOperation(value = "取值", notes = "取值")
	@GetMapping(value = "/get/{key}")
	public Result<String> get(@PathVariable String key) throws Exception {
		demoRedisService.getValue(key);
		return new ResultBuilder<String>().success();
	}
	@ApiOperation(value = "是否存在", notes = "是否存在")
	@GetMapping(value = "/has/{key}")
	public Result<String> has(@PathVariable String key) throws Exception {
		demoRedisService.hasKey(key);
		return new ResultBuilder<String>().success();
	}
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping(value = "/del/{key}")
	public Result<String> del(@PathVariable String key) throws Exception {
		demoRedisService.delKey(key);
		return new ResultBuilder<String>().success();
	}
}
