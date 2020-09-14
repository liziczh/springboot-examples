package com.liziczh.springboot.mybatis.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.liziczh.base.common.entity.BaseEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TDemo extends BaseEntity {
	private static final long serialVersionUID = -3399850105386695874L;
	@ApiModelProperty(value = "ID")
	@JsonProperty("id")
	private Integer id;
	@ApiModelProperty(value = "姓名")
	@JsonProperty("name")
	private String name;
	@ApiModelProperty(value = "创建时间")
	@JsonProperty("create_time")
	private Date createTime;
	@ApiModelProperty(value = "创建人")
	@JsonProperty("create_user")
	private String createUser;
	@ApiModelProperty(value = "更新时间")
	@JsonProperty("update_time")
	private Date updateTime;
	@ApiModelProperty(value = "更新人")
	@JsonProperty("update_user")
	private String updateUser;
	@ApiModelProperty(value = "权限角色")
	@JsonProperty("permit_role")
	private String permitRole;
	@ApiModelProperty(value = "是否有效")
	@JsonProperty("valid")
	private String valid;
}
