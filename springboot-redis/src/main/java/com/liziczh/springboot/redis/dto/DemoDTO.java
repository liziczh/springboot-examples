package com.liziczh.springboot.redis.dto;

import java.util.Date;

import lombok.Data;

@Data
public class DemoDTO {
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