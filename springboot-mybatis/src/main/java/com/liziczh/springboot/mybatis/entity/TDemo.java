package com.liziczh.springboot.mybatis.entity;

import java.util.Date;

import lombok.Data;

@Data
public class TDemo {
    private Long id;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;

    private Integer version;

    private Integer isDel;

    private Long demoId;

    private String name;

    private String desc;
}