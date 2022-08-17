package com.liziczh.springboot.swagger.api.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@ApiModel(value = "DTO")
@Data
@ToString
public class DemoDTO {

    @ApiModelProperty(value = "ID", notes = "ID")
    private Long id;

    @ApiModelProperty(value = "创建时间", notes = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人", notes = "创建人")
    private String createUser;

    @ApiModelProperty(value = "更新时间", notes = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "更新人", notes = "更新人")
    private String updateUser;

    @ApiModelProperty(value = "版本号", notes = "乐观锁版本号")
    private Integer version;

    @ApiModelProperty(value = "是否删除", notes = "是否删除")
    private Integer isDel;

    @ApiModelProperty(value = "唯一ID", notes = "唯一ID")
    private Long demoId;

    @ApiModelProperty(value = "名称", notes = "名称")
    private String name;

    @ApiModelProperty(value = "描述", notes = "描述")
    private String desc;
}