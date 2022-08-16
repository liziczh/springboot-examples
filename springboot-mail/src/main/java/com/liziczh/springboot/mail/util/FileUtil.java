package com.liziczh.springboot.mail.util;

import java.io.File;

import lombok.extern.slf4j.Slf4j;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/6/15 10:14 下午
 */
@Slf4j
public class FileUtil {

    /**
     * 删除临时文件
     *
     * @author chenzhehao
     * @date 2021/11/22 9:36 下午
     */
    public static boolean delTempFile(String tmpFilePath) {
        log.info("FileUtil.delTempFile, start, tmpFilePath={}",
                tmpFilePath);
        boolean delete = false;
        File tmpFile = new File(tmpFilePath);
        if (tmpFile.exists()) {
            delete = tmpFile.delete();
            log.info("FileUtil.delTempFile, success, delete={}, tmpFilePath={}",
                    delete, tmpFilePath);
        } else {
            log.error("FileUtil.delTempFile, file does not exist, tmpFilePath={}",
                    tmpFilePath);
        }
        log.info("FileUtil.delTempFile, end, delete={}, tmpFilePath={}, ",
                delete, tmpFilePath);
        return delete;
    }

}
