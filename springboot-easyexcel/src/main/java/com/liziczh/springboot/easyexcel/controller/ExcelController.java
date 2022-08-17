package com.liziczh.springboot.easyexcel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liziczh.springboot.easyexcel.service.ExcelService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/excel/")
@RestController
public class ExcelController {
	@Autowired
	private ExcelService excelService;

	@RequestMapping(value = "format", method = RequestMethod.POST)
	public void formatJsonString(@RequestParam String importFileName, @RequestParam String exportFileName) {
		excelService.formatData(importFileName, exportFileName);
	}

	@RequestMapping(value = "download", method = RequestMethod.POST)
	public void download() {
		excelService.export();
	}
}
