package com.szhrnet.taoqiapp.mvp.contract;


import com.szhrnet.taoqiapp.base.BaseContract;
import com.szhrnet.taoqiapp.mvp.model.LoginModel;

/**
 * <pre>
 *     author: Zou Juequn
 *     email:15695947865@139.com
 * </pre>
 */
public interface ExampleContract {
    interface Presenter extends BaseContract.Presenter {
        void doLogin();
    }

    interface View extends BaseContract.View<Presenter> {
        void onDoLoginSuccessful(LoginModel model);
    }
}
