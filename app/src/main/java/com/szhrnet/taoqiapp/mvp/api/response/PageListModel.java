package com.szhrnet.taoqiapp.mvp.api.response;


/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : PageListModel类
 *     email:15695947865@139.com
 * </pre>
 */

@SuppressWarnings({"WeakerAccess", "unused"})
public class PageListModel<T> {    private boolean is_last;
    private T list;


    public boolean is_last() {
        return is_last;
    }

    public void setIs_last(boolean is_last) {
        this.is_last = is_last;
    }

    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }
}
