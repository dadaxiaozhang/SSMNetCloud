package com.lanou.utils;

/**
 * Created by dllo on 17/12/6.
 * 嗯，这是这个工程唯一的注释
 */

//自己写的！！！！！！
public class AjaxResult {

    private Integer errorCode;
    private String msg;
    private Object data;


    public AjaxResult() {
    }

    public AjaxResult(Integer errorCode, String msg, Object data) {
        this.errorCode = errorCode;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "AjaxResult{" +
                "errorCode=" + errorCode +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
