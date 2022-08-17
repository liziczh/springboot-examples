package com.liziczh.springboot.easyexcel.dto.excel;

import java.util.Date;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

import lombok.Data;

@Data
public class ExportDataModel {
    @ExcelProperty(value = "ID", index = 0)
    @ColumnWidth(6)
    private Integer id;
    @ExcelProperty(value = "名称", index = 1)
    @ColumnWidth(10)
    private String name;
    @ExcelProperty(value = "创建时间", index = 2)
    @ColumnWidth(20)
    private Date createTime;
    @ExcelProperty(value = "创建用户", index = 3)
    @ColumnWidth(12)
    private String createUser;
    @ExcelProperty(value = "更新时间", index = 4)
    @ColumnWidth(20)
    private Date updateTime;
    @ExcelProperty(value = "更新用户", index = 5)
    @ColumnWidth(12)
    private String updateUser;
}
