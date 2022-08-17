package com.liziczh.springboot.web.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 响应体
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/12/10 11:06 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseResponse<T> {

    /**
     * 状态码
     */
    private String code;

    /**
     * 状态信息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

}
