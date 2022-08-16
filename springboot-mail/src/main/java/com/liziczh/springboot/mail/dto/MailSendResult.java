package com.liziczh.springboot.mail.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 邮件发送结果
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/8/23 9:23 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MailSendResult {

    /**
     * 邮件发送状态：成功/失败
     */
    private Boolean status;

    /**
     * 邮件发送请求JSON
     */
    private String requestJson;

    /**
     * 邮件发送响应JSON
     */
    private String responseJson;

}
