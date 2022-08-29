package com.liziczh.springboot.web.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@ApiModel(value = "测试额外信息DTO")
@Data
@ToString
public class DemoExtraDTO {


    @ApiModelProperty(value = "邮箱", notes = "邮箱")
    @Email(message = "邮箱有误")
    private String email;

    @ApiModelProperty(value = "手机号", notes = "手机号")
    @NotBlank(message = "手机号不可为空")
    @Pattern(regexp = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$", message = "手机号码有误")
    private String mobile;
}