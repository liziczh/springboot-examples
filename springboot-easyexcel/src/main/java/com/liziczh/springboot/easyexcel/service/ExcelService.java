package com.liziczh.springboot.easyexcel.service;

import java.util.List;

import com.liziczh.springboot.easyexcel.condition.DemoCondition;
import com.liziczh.springboot.easyexcel.dto.excel.UploadDataModel;

/**
 * @author zhehao.chen
 */
public interface ExcelService {
	/**
	 * 导入Excel表
	 *
	 * @throws Exception
	 */
	void uploadExcel(String fileName) throws Exception;

	/**
	 * 导出Excel表
	 *
	 * @return 文件流
	 * @throws Exception e
	 */
	void exportExcel(List<UploadDataModel> dataModelList) throws Exception;

	/**
	 * 导出Demo表
	 *
	 * @param condition 条件
	 * @return 文件流
	 * @throws Exception e
	 */
	void exportDemo(DemoCondition condition) throws Exception;
}
