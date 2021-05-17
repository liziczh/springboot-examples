package com.liziczh.springboot.easyexcel.listener;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.liziczh.springboot.easyexcel.dto.excel.UploadDataModel;
import com.liziczh.springboot.easyexcel.service.ExcelService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UploadDataListener extends AnalysisEventListener<UploadDataModel> {
	private ExcelService excelService;
	private List<UploadDataModel> dataList = new ArrayList<>();
	public UploadDataListener(ExcelService excelService) {
		this.excelService = excelService;
	}
	@Override
	public void invoke(UploadDataModel model, AnalysisContext analysisContext) {
		// 保存数据
		log.info("content：{}", model.getContent());
		String jsonString = model.getContent();
		JSONObject object = JSONObject.parseObject(jsonString);
		String jsonResult = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteDateUseDateFormat);
		model.setJsonContent(jsonResult);
		log.info("JsonContent：{}", model.getJsonContent());
		dataList.add(model);
	}
	@Override
	public void doAfterAllAnalysed(AnalysisContext analysisContext) {
		// 后置处理
		try {
			excelService.exportExcel(dataList);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
