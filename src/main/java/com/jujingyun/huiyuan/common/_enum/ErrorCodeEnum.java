package com.jujingyun.huiyuan.common._enum;

/**
 * 错误码
 */
public enum ErrorCodeEnum {

    SUCCESS(200, "执行成功"),

    UNAUTHORIZED(401, "要求身份验证"),
    FAILED(406, "执行失败"),

    ERROR(500, "系统异常");

    private int code;
    private String msg;
    ErrorCodeEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
