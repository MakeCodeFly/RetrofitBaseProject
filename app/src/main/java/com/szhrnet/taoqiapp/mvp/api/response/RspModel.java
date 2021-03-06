package com.szhrnet.taoqiapp.mvp.api.response;
/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : RspModel返回类
 *     email:15695947865@139.com
 * </pre>
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class RspModel<T> {
    public static final int SUCCEED = 1;

    private int status;
    private int code;
    private String msg;
    private T data;


    public boolean success() {
        return status == SUCCEED;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
}