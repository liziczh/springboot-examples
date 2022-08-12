package com.liziczh.springboot.mybatis.condition;

import java.util.Date;


import lombok.Data;

@Data
public class DemoCondition {
    private PageCondition pageCondition;
    private String name;
    private Date startTime;
    private Date endTime;
}
