package com.szhrnet.taoqiapp.mvp.api.support;


import com.szhrnet.taoqiapp.base.BaseApplication;
import com.szhrnet.taoqiapp.utils.LogUtils;


/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : Logger类
 *     email:15695947865@139.com
 * </pre>
 */

public class Logger implements LoggingInterceptor.Logger {

    @Override
    public void log(String message) {
        LogUtils.e(BaseApplication.TAG, message);
    }
}
