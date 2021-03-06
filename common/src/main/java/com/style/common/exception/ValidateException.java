package com.style.common.exception;

import com.style.common.constant.ErrorCode;
import com.style.common.utils.MsgUtils;

/**
 * 验证异常
 */
public class ValidateException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;

    public ValidateException(int code) {
        this.code = code;
        this.msg = MsgUtils.getMessage(code);
    }

    public ValidateException(int code, String... params) {
        this.code = code;
        this.msg = MsgUtils.getMessage(code, params);
    }

    public ValidateException(int code, Throwable e) {
        super(e);
        this.code = code;
        this.msg = MsgUtils.getMessage(code);
    }

    public ValidateException(int code, Throwable e, String... params) {
        super(e);
        this.code = code;
        this.msg = MsgUtils.getMessage(code, params);
    }

    public ValidateException(String msg) {
        super(msg);
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
        this.msg = msg;
    }

    public ValidateException(String msg, Throwable e) {
        super(msg, e);
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
