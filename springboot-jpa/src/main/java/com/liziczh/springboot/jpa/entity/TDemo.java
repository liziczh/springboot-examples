package com.liziczh.springboot.jpa.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "t_demo")
public class TDemo implements Serializable {
	private static final long serialVersionUID = -4646552816619287719L;
	@ApiModelProperty(value = "ID")
	@JsonProperty("id")
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	private Integer id;
	@ApiModelProperty(value = "姓名")
	@JsonProperty("name")
	@Column(name = "NAME")
	private String name;
	@ApiModelProperty(value = "创建时间")
	@JsonProperty("create_time")
	@Column(name = "CREATE_TIME")
	private Date createTime;
	@ApiModelProperty(value = "创建人")
	@JsonProperty("create_user")
	@Column(name = "CREATE_USER")
	private String createUser;
	@ApiModelProperty(value = "更新时间")
	@JsonProperty("update_time")
	@Column(name = "UPDATE_TIME")
	private Date updateTime;
	@ApiModelProperty(value = "更新人")
	@JsonProperty("update_user")
	@Column(name = "UPDATE_USER")
	private String updateUser;
	@ApiModelProperty(value = "权限角色")
	@JsonProperty("permit_role")
	@Column(name = "PERMIT_ROLE")
	private String permitRole;
	@ApiModelProperty(value = "是否有效")
	@JsonProperty("valid")
	@Column(name = "VALID")
	private String valid;
}
