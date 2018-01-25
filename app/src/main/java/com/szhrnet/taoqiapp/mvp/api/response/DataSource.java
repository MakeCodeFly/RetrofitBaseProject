package com.szhrnet.taoqiapp.mvp.api.response;


/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : 数据源接口定义 DataSource类
 *     email:15695947865@139.com
 * </pre>
 */

public interface DataSource {

    /**
     * 同时包括了成功与失败的回调接口
     *
     * @param <T> 任意类型
     */
    interface Callback<T> extends SucceedCallback<T>, FailedCallback {

    }

    /**
     * 成功的接口
     *
     * @param <T> 任意类型
     */
    interface SucceedCallback<T> {
        // 数据加载成功, 网络请求成功
        void onDataResponseSucceed(T t);

    }

    /**
     * 失败的接口
     */
    interface FailedCallback {
        // 数据加载失败, 网络请求失败
        void onDataResponseFailed(String strRes);
    }
}
