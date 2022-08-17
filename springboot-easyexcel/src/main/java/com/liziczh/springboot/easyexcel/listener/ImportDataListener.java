package com.liziczh.springboot.easyexcel.listener;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.liziczh.springboot.easyexcel.dto.excel.ImportDataModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ImportDataListener extends AnalysisEventListener<ImportDataModel> {

    private String exportFileName;
    private List<ImportDataModel> dataList = new ArrayList<>();

    public ImportDataListener(String exportFileName) {
        this.exportFileName = exportFileName;
    }

    @Override
    public void invoke(ImportDataModel model, AnalysisContext analysisContext) {
        // 保存数据
        log.info("content：{}", model.getContent());
        String jsonString = model.getContent();

        JSONObject object = JSONObject.parseObject(jsonString);
        String jsonResult = JSON.toJSONString(object, SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);

        model.setJsonContent(jsonResult);
        log.info("JsonContent：{}", model.getJsonContent());
        dataList.add(model);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 后置处理
        try {
            // 导出
            EasyExcel.write(exportFileName, ImportDataModel.class).sheet("sheet1").doWrite(dataList);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
