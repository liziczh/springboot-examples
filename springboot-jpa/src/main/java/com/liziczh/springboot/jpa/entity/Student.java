package com.liziczh.springboot.jpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @CreatedDate
    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @CreatedBy
    @Column(name = "create_user")
    private String createUser;

    @LastModifiedDate
    @Column(name = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @LastModifiedBy
    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "version")
    private Integer version;

    @Column(name = "is_del")
    private Integer isDel;

    @Column(name = "demo_id")
    private Long demoId;

    @Column(name = "name")
    private String name;

    @Column(name = "desc")
    private String desc;
}
