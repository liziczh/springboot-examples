package com.liziczh.springboot.mybatisplus.dto;

import lombok.Data;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/12/29 8:11 PM
 */
@Data
public class StudentSchoolDTO {
    private Long studentId;

    private Long schoolId;

    private String studentName;

    private String schoolName;
}
