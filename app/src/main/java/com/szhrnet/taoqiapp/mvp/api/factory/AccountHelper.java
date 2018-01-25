package com.szhrnet.taoqiapp.mvp.api.factory;

import com.szhrnet.taoqiapp.mvp.api.response.DataSource;
import com.szhrnet.taoqiapp.mvp.api.response.ProfitApi;
import com.szhrnet.taoqiapp.mvp.api.response.RspModel;
import com.szhrnet.taoqiapp.mvp.model.LoginModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : AccountHelper类
 *     email:15695947865@139.com
 * </pre>
 */

public class AccountHelper {

    public static Call doLogin(String user_name, String user_pwd, final DataSource.Callback<LoginModel> callback) {
        BookApiService bookApiService = ProfitApi.remoteBookApiService();

        Call<RspModel<LoginModel>> call = bookApiService.doLogin(user_name,user_pwd);
        call.enqueue(new Callback<RspModel<LoginModel>>() {
            @Override
            public void onResponse(Call<RspModel<LoginModel>> call, Response<RspModel<LoginModel>> response) {
                RspModel<LoginModel> rspModel = response.body();
                if (null != rspModel && rspModel.success()) {
                    callback.onDataResponseSucceed(rspModel.getData());
                } else {
                    ProfitApi.decodeRspCode(rspModel,callback);
                }
            }

            @Override
            public void onFailure(Call<RspModel<LoginModel>> call, Throwable t) {
                callback.onDataResponseFailed("网络不可用");
            }

        });
        return call;
    }
}