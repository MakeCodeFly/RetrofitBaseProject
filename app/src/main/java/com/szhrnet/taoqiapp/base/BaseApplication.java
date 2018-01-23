package com.szhrnet.taoqiapp.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.szhrnet.taoqiapp.mvp.model.UserAccount;


/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : BaseApplication类
 *     email:15695947865@139.com
 * </pre>
 */
public class BaseApplication extends Application {

    private static BaseApplication instance;

    public static final String TAG = "ProfitApp";
    public static final String MSG = "ProfitApp_MSG";
    public static final String LOGIN_OUT = "LOGIN_OUT";
    public static final String ACTION_PAY_SUCCESS = "ACTION_PAY_SUCCESS";
    public static final String ACTION_PAY_FAUILURE = "ACTION_PAY_FAUILURE";
    public static final int REQUEST_CODE = 0x33;
    public static  String userToken ;


    public BaseApplication() {

    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        UserAccount.load(this);//加载保存本地的数据

    }



    @Override
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //you must install multiDex whatever tinker is installed!
        MultiDex.install(base);
    }

    public static BaseApplication getInstance() {
        return instance;
    }

    public static void setInstance(BaseApplication instance) {
        BaseApplication.instance = instance;
    }

    public static void setUserToken(String userToken) {
        BaseApplication.userToken = userToken;
    }

    public static String getUserToken() {
        return userToken;
    }
}
