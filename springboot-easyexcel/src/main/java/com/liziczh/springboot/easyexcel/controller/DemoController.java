package com.liziczh.springboot.easyexcel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liziczh.springboot.easyexcel.condition.DemoCondition;
import com.liziczh.springboot.easyexcel.service.ExcelService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/excel/")
@RestController
public class DemoController {
	@Autowired
	private ExcelService excelService;
	@RequestMapping(value = "formatData", method = RequestMethod.POST)
	public void formatJsonString(@RequestParam String uploadFileName, @RequestParam String exportFileName) throws Exception {
		excelService.formatData(uploadFileName, exportFileName);
	}
	@RequestMapping(value = "download", method = RequestMethod.POST)
	public void download(@RequestBody DemoCondition condition) throws Exception {
		excelService.exportDemo(condition);
	}
}
