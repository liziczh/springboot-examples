package com.liziczh.springboot.easyexcel.dto.excel;

import java.util.Date;

import com.alibaba.excel.annotation.ExcelProperty;

import lombok.Data;

/**
 * 对接百度健康订单信息
 *
 * @author zhehao.chen
 */
@Data
public class UploadDataModel {
	private static final long serialVersionUID = -4759455543086580031L;
	@ExcelProperty(value = "rule_id", index = 0)
	private Integer ruleId;
	@ExcelProperty(value = "country_code", index = 1)
	private String countryCode;
	@ExcelProperty(value = "main_rule_id", index = 2)
	private Date mainRuleId;
	@ExcelProperty(value = "language", index = 3)
	private String language;
	@ExcelProperty(value = "content", index = 4)
	private String content;
	@ExcelProperty(value = "typeCode", index = 5)
	private String typeCode;
	@ExcelProperty(value = "target", index = 6)
	private String target;
	@ExcelProperty(value = "json_content", index = 7)
	private String jsonContent;
}
