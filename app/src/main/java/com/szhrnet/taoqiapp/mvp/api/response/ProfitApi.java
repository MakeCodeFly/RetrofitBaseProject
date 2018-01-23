/**
 * Copyright 2016 JustWayward Team
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.szhrnet.taoqiapp.mvp.api.response;



import com.szhrnet.taoqiapp.config.URLConfig;
import com.szhrnet.taoqiapp.mvp.api.factory.BookApiService;
import com.szhrnet.taoqiapp.mvp.api.support.HeaderInterceptor;
import com.szhrnet.taoqiapp.mvp.api.support.Logger;
import com.szhrnet.taoqiapp.mvp.api.support.LoggingInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfitApi {

    public static ProfitApi instance;

    private Retrofit retrofit;

    private OkHttpClient client;

    public static ProfitApi getInstance() {
        synchronized (ProfitApi.class) {
            if (instance == null) {
                instance = new ProfitApi();
            }
            return instance;
        }
    }

    private static OkHttpClient getClient() {
        if (instance.client != null)
            return instance.client;

        LoggingInterceptor logging = new LoggingInterceptor(new Logger());
        logging.setLevel(LoggingInterceptor.Level.BODY);
        instance.client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true) // 失败重发
                .addInterceptor(new HeaderInterceptor())
                .addInterceptor(logging)
                .build();
        return instance.client;
    }

    // 构建一个Retrofit
    private static Retrofit getRetrofit() {
        if (instance.retrofit != null)
            return instance.retrofit;
        OkHttpClient client = getClient();
        instance.retrofit = new Retrofit.Builder()
                .baseUrl(URLConfig.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(client)
                .build();

        return instance.retrofit;
    }

    /**
     * 返回一个请求代理
     *
     * @return RemoteBookApiService
     */
    public static BookApiService remoteBookApiService() {
        return getInstance().getRetrofit().create(BookApiService.class);
    }



    /**
     * 进行错误Code的解析，
     * 把网络返回的Code值进行统一的规划并返回为一个String资源
     * @param model    RspModel
     * @param callback DataSource.FailedCallback 用于返回一个错误的资源Id
     */
    public static void decodeRspCode(RspModel model, DataSource.FailedCallback callback) {
        if (model == null)
            return;
        switch (model.getCode()){
            //
            case 101:
                break;
            default:
                break;
        }

    }


}
