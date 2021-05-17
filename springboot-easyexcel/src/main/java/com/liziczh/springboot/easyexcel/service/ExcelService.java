package com.liziczh.springboot.easyexcel.service;

import com.liziczh.springboot.easyexcel.condition.DemoCondition;

/**
 * @author zhehao.chen
 */
public interface ExcelService {
	/**
	 * 导入Excel表格式化数据后导出
	 *
	 * @throws Exception
	 */
	void formatData(String uploadFileName, String exportFileName) throws Exception;

	/**
	 * 导出Demo表
	 *
	 * @param condition 条件
	 * @return 文件流
	 * @throws Exception e
	 */
	void exportDemo(DemoCondition condition) throws Exception;
}
