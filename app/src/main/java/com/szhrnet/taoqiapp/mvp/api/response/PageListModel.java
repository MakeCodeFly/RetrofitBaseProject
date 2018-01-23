package com.szhrnet.taoqiapp.mvp.api.response;

/**
 * Created by tangzelai on 2017/7/4.
 * com.szhrnet.factory.model.api.home
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
