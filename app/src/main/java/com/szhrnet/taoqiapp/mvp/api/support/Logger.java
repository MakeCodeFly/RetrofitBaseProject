package com.szhrnet.taoqiapp.mvp.api.support;


import com.szhrnet.taoqiapp.base.BaseApplication;
import com.szhrnet.taoqiapp.utils.LogUtils;

public class Logger implements LoggingInterceptor.Logger {

    @Override
    public void log(String message) {
        LogUtils.e(BaseApplication.TAG, message);
    }
}
