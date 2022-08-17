package com.liziczh.springboot.easyexcel.dto.excel;

import com.alibaba.excel.annotation.ExcelProperty;

import lombok.Data;

@Data
public class ImportDataModel {
    @ExcelProperty(value = "rule_id", index = 0)
    private Integer ruleId;
    @ExcelProperty(value = "country_code", index = 1)
    private String countryCode;
    @ExcelProperty(value = "target", index = 2)
    private String target;
    @ExcelProperty(value = "language", index = 3)
    private String language;
    @ExcelProperty(value = "type_code", index = 4)
    private String typeCode;
    @ExcelProperty(value = "category_one_name", index = 5)
    private String categoryOneName;
    @ExcelProperty(value = "category_four_name", index = 6)
    private String categoryFourName;
    @ExcelProperty(value = "content", index = 7)
    private String content;
    @ExcelProperty(value = "json_content", index = 8)
    private String jsonContent;
}
