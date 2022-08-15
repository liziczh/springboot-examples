package com.liziczh.springboot.mybatisplus.condition;

import lombok.Data;

/**
 * 分页查询条件
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/7/17 21:52
 */
@Data
public class PageCondition {
    private Integer pageNo = 1;
    private Integer pageSize = 10;
}
