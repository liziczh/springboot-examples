package com.liziczh.springboot.mybatisplus.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;

import lombok.Data;

@Data
@TableName(value = "school")
public class School {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(value = "create_user")
    private String createUser;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "update_user")
    private String updateUser;

    @TableField(value = "version")
    @Version
    private Integer version;

    @TableField(value = "is_del")
    @TableLogic(value = "0", delval = "1")
    private Integer isDel;

    @TableField(value = "school_id")
    private Long schoolId;

    @TableField(value = "name")
    private String name;

    @TableField(value = "desc")
    private String desc;
}
