package com.zlt.common;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/2 22:02
 * @version: 1.0
 * @modified By:
 */
public class ResultCode<T> {
    private int code;
    private String msg;
    private T data;

    public ResultCode() {
    }

    public ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultCode(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
