package com.liziczh.springboot.easyexcel.service;

/**
 * @author zhehao.chen
 */
public interface ExcelService {
    /**
     * 格式化数据
     *
     * @param importFileName
     * @param exportFileName
     * @return void
     * @author chenzhehao
     * @date 2022/8/17 11:05 AM
     */
    void formatData(String importFileName, String exportFileName);

    /**
     * 导出数据
     *
     * @param
     * @return void
     * @author chenzhehao
     * @date 2022/8/17 11:05 AM
     */
    void export();
}
