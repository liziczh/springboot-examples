package com.liziczh.springboot.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liziczh.base.common.result.Result;
import com.liziczh.base.common.result.ResultBuilder;
import com.liziczh.springboot.jpa.condition.JpaCondition;
import com.liziczh.springboot.jpa.entity.TDemo;
import com.liziczh.springboot.jpa.service.DemoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "示例接口", tags = "示例接口")
@RequestMapping(value = "/demo/")
@RestController
public class DemoController {
	@Autowired
	private DemoService demoService;

	@ApiOperation(value = "hello", notes = "测试接口")
	@GetMapping(value = "hello")
	public Result<String> hello() {
		return new ResultBuilder<String>().complete("HelloWorld");
	}
	@ApiOperation(value = "条件查询", notes = "条件查询")
	@GetMapping(value = "/select")
	public Result<Page<TDemo>> select(@RequestBody JpaCondition<TDemo> condition) throws Exception {
		Page<TDemo> demoList = demoService.selectByCondition(condition);
		return new ResultBuilder<Page<TDemo>>().complete(demoList);
	}
	@ApiOperation(value = "查询全部", notes = "查询全部")
	@GetMapping(value = "/getAll")
	public Result<List<TDemo>> getAll() throws Exception {
		List<TDemo> demoList = demoService.getAll();
		return new ResultBuilder<List<TDemo>>().complete(demoList);
	}
	@ApiOperation(value = "新增接口", notes = "新增接口")
	@PostMapping(value = "add")
	public Result<String> addDemo(TDemo demo) throws Exception {
		demoService.addDemo(demo);
		return new ResultBuilder<String>().success();
	}
	@ApiOperation(value = "更新接口", notes = "更新接口")
	@PutMapping(value = "update")
	public Result<String> updateDemo(TDemo demo) throws Exception {
		demoService.updateDemo(demo);
		return new ResultBuilder<String>().success();
	}
	@ApiOperation(value = "获取接口", notes = "获取接口")
	@GetMapping(value = "/get/{id}")
	public Result<TDemo> getDemo(@PathVariable String id) throws Exception {
		TDemo demo = demoService.getDemo(id);
		return new ResultBuilder<TDemo>().complete(demo);
	}
	@ApiOperation(value = "删除接口", notes = "删除接口")
	@DeleteMapping(value = "/delete/{id}")
	public Result<String> deleteDemo(@PathVariable String id) throws Exception {
		demoService.deleteDemo(id);
		return new ResultBuilder<String>().success();
	}
}
