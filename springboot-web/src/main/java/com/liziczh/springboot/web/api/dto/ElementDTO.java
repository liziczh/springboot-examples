package com.liziczh.springboot.web.api.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@ApiModel(value = "元素信息DTO")
@Data
@ToString
public class ElementDTO {

    @ApiModelProperty(value = "名称", notes = "名称")
    @Length(min = 1, max = 5, message = "名称应该在1-5个字符之间")
    @NotBlank(message = "名称不可为空")
    private String name;

    @ApiModelProperty(value = "描述", notes = "描述")
    @Length(max = 200, message = "描述应该在200个字符以内")
    @NotBlank(message = "描述不可为空")
    private String desc;

}