package com.jujingyun.huiyuan.common._enum;

/**
 * 错误码
 */
public enum ErrorCodeEnum {

    SUCCESS(200, "执行成功"),
    ERROR(500, "系统异常"),
    FAILED(501, "操作失败");

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
