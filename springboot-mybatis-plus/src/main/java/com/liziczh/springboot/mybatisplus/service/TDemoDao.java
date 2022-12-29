package com.liziczh.springboot.mybatisplus.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liziczh.springboot.mybatisplus.entity.TDemo;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/12/29 7:28 PM
 */
public interface TDemoDao extends IService<TDemo> {

    Page<TDemo> getPage(long pageNo, long pageSize);

    List<TDemo> getList();

    TDemo getById(long id);

    Boolean addTDemo(TDemo demo);

    Boolean updateTDemo(TDemo demo);

    Boolean removeTDemo(long id);
}
