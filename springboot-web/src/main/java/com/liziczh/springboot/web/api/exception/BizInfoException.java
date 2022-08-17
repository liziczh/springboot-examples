package com.liziczh.springboot.web.api.exception;

import lombok.Data;

/**
 * 业务INFO异常
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/7/17 21:52
 */
@Data
public class BizInfoException extends RuntimeException {
    private static final long serialVersionUID = -2999713747880719040L;

    private String code;

    public BizInfoException() {
        super();
    }

    public BizInfoException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BizInfoException(String message) {
        super(message);
    }

    public BizInfoException(Throwable cause) {
        super(cause);
    }

    public BizInfoException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizInfoException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
