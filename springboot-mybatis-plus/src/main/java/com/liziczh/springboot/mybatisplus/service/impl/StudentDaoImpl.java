package com.liziczh.springboot.mybatisplus.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.liziczh.springboot.mybatisplus.dto.StudentSchoolDTO;
import com.liziczh.springboot.mybatisplus.entity.School;
import com.liziczh.springboot.mybatisplus.entity.Student;
import com.liziczh.springboot.mybatisplus.mapper.StudentMapper;
import com.liziczh.springboot.mybatisplus.service.StudentDao;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/12/29 7:30 PM
 */
@Service
public class StudentDaoImpl extends ServiceImpl<StudentMapper, Student> implements StudentDao {

    @Override
    public IPage<StudentSchoolDTO> getStudentSchoolList(long pageNo, long pageSize) {
        MPJLambdaWrapper<Student> mpjLambdaWrapper = new MPJLambdaWrapper<>();
        mpjLambdaWrapper.selectAll(Student.class).selectAll(School.class)
            .leftJoin(School.class, School::getSchoolId, Student::getSchoolId);
        return baseMapper.selectJoinPage(new Page<>(pageNo, pageSize),
            StudentSchoolDTO.class, mpjLambdaWrapper);
    }

    @Override
    public Page<Student> getPage(long pageNo, long pageSize) {
        return this.lambdaQuery().page(new Page<>(pageNo, pageSize));
    }

    @Override
    public List<Student> getList() {
        return this.lambdaQuery().list();
    }

    @Override
    public Student getById(long id) {
        return this.lambdaQuery()
            .eq(Objects.nonNull(id), Student::getId, id)
            .one();
    }

    @Override
    public Boolean addStudent(Student demo) {
        return this.save(demo);
    }

    @Override
    public Boolean updateStudent(Student demo) {
        return this.updateById(demo);
    }

    @Override
    public Boolean removeStudent(long id) {
        return this.removeById(id);
    }
}
