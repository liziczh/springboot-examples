package com.liziczh.springboot.mybatisplus.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liziczh.springboot.mybatisplus.dto.StudentSchoolDTO;
import com.liziczh.springboot.mybatisplus.entity.Student;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/12/29 7:28 PM
 */
public interface StudentDao extends IService<Student> {

    IPage<StudentSchoolDTO> getStudentSchoolList(long pageNo, long pageSize);

    Page<Student> getPage(long pageNo, long pageSize);

    List<Student> getList();


    Student getById(long id);

    Boolean addStudent(Student demo);

    Boolean updateStudent(Student demo);

    Boolean removeStudent(long id);
}
