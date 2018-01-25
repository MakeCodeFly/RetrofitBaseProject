package com.szhrnet.taoqiapp.utils;

/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : EventBusModel类
 *     email:15695947865@139.com
 * </pre>
 */
public class EventBusModel {

    private String data;
    private String msg;
    private Object object;
    private String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
