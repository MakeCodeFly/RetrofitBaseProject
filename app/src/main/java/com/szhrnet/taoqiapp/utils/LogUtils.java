package com.szhrnet.taoqiapp.utils;

import android.util.Log;

import com.szhrnet.taoqiapp.BuildConfig;


/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : LogUtils类
 *     email:15695947865@139.com
 * </pre>
 */
public class LogUtils {

    public static void d(String tag, String message) {
        if (BuildConfig.LOG_DEBUG) Log.d(tag, message);
    }

    public static void e(String tag, String message) {
        if (BuildConfig.LOG_DEBUG) Log.e(tag, message);
    }
}
