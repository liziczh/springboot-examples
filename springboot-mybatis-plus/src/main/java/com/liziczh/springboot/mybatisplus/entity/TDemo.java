package com.liziczh.springboot.mybatisplus.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName(value = "t_demo")
public class TDemo {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "create_user")
    private String createUser;

    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(value = "update_user")
    private String updateUser;

    @TableField(value = "version")
    private Integer version;

    @TableField(value = "is_del")
    private Integer isDel;

    @TableField(value = "demo_id")
    private Long demoId;

    @TableField(value = "name")
    private String name;

    @TableField(value = "desc")
    private String desc;
}
