package com.liziczh.springboot.web.api.dto;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@ApiModel(value = "测试DemoDTO")
@Data
@ToString
public class DemoDTO {

    @ApiModelProperty(value = "ID", notes = "ID")
    private Long id;

    @ApiModelProperty(value = "创建时间", notes = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value = "创建人", notes = "创建人")
    private String createUser;

    @ApiModelProperty(value = "更新时间", notes = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
    @NotBlank(message = "名称不可为空")
    @Length(min = 1, max = 5, message = "名称应该在1-5个字符之间")
    private String name;

    @ApiModelProperty(value = "描述", notes = "描述")
    @NotBlank(message = "描述不可为空")
    @Length(max = 200, message = "描述应该在200个字符以内")
    private String desc;

    @ApiModelProperty(value = "年龄", notes = "年龄")
    @Range(min = 18, max = 60, message = "年龄应该在18-60之间")
    private String age;

    @ApiModelProperty(value = "额外信息", notes = "额外信息")
    @NotNull(message = "额外信息不可为空")
    @Valid
    private DemoExtraDTO extraInfo;

    @ApiModelProperty(value = "元素列表", notes = "元素列表")
    @NotEmpty(message = "元素列表不可为空")
    @Size(min = 1, max = 5, message = "元素列表数据过长")
    @Valid
    private List<ElementDTO> elementList;

}