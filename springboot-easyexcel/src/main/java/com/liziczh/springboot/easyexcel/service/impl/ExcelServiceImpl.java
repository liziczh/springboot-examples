package com.liziczh.springboot.easyexcel.service.impl;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.liziczh.springboot.easyexcel.dto.excel.ExportDataModel;
import com.liziczh.springboot.easyexcel.dto.excel.ImportDataModel;
import com.liziczh.springboot.easyexcel.listener.ImportDataListener;
import com.liziczh.springboot.easyexcel.service.ExcelService;

import lombok.extern.slf4j.Slf4j;

/**
 * Excel导出
 *
 * @author zhehao.chen
 */
@Slf4j
@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private HttpServletResponse response;

    @Override
    public void formatData(String importFileName, String exportFileName) {
        EasyExcel.read(importFileName, ImportDataModel.class, new ImportDataListener(exportFileName)).sheet().doRead();
    }

    @Override
    public void export() {
        // 导出
        ServletOutputStream outputStream;
        ExcelWriter writer = null;
        try {
            outputStream = response.getOutputStream();
            writer = EasyExcelFactory.write(outputStream, ExportDataModel.class).build();
            WriteSheet sheet = EasyExcelFactory.writerSheet("sheet1").build();
            writer.write(this.data(), sheet);
            // response stream
            String fileName = URLEncoder.encode("导出数据列表", "UTF-8");
            this.download(fileName);
        } catch (Exception e) {
            log.error("export error", e);
        } finally {
            if (writer != null) {
                writer.finish();
            }
        }
    }

    /**
     * 获取导出数据
     *
     * @return java.util.List<ExportDataModel>
     * @author chenzhehao
     * @date 2022/8/17 11:07 AM
     */
    private List<ExportDataModel> data() {
        // TODO 获取导出数据
        List<ExportDataModel> dataList = new ArrayList<>();
        return dataList;
    }

    /**
     * 下载Excel文件
     *
     * @param fileName 文件名
     */
    private void download(String fileName) {
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
    }
}
