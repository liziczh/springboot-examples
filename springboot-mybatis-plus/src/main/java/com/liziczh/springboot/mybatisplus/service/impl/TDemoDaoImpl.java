package com.liziczh.springboot.mybatisplus.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liziczh.springboot.mybatisplus.entity.TDemo;
import com.liziczh.springboot.mybatisplus.mapper.TDemoMapper;
import com.liziczh.springboot.mybatisplus.service.TDemoDao;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/12/29 7:30 PM
 */
@Service
public class TDemoDaoImpl extends ServiceImpl<TDemoMapper, TDemo> implements TDemoDao {
    @Override
    public Page<TDemo> getPage(long pageNo, long pageSize) {
        return this.lambdaQuery().page(new Page<>(pageNo, pageSize));
    }

    @Override
    public List<TDemo> getList() {
        return this.lambdaQuery().list();
    }

    @Override
    public TDemo getById(long id) {
        return this.lambdaQuery()
            .eq(Objects.nonNull(id), TDemo::getId, id)
            .one();
    }

    @Override
    public Boolean addTDemo(TDemo demo) {
        return this.save(demo);
    }

    @Override
    public Boolean updateTDemo(TDemo demo) {
        return this.updateById(demo);
    }

    @Override
    public Boolean removeTDemo(long id) {
        return this.removeById(id);
    }
}
