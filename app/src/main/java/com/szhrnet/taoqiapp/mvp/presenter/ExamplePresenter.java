package com.szhrnet.taoqiapp.mvp.presenter;



import com.szhrnet.taoqiapp.base.BasePresenter;
import com.szhrnet.taoqiapp.mvp.api.factory.AccountHelper;
import com.szhrnet.taoqiapp.mvp.api.response.DataSource;
import com.szhrnet.taoqiapp.mvp.contract.ExampleContract;
import com.szhrnet.taoqiapp.mvp.model.LoginModel;

import retrofit2.Call;

/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : 事例Presenter
 *     email:15695947865@139.com
 * </pre>
 */
public class ExamplePresenter extends BasePresenter<ExampleContract.View>
        implements ExampleContract.Presenter, DataSource.Callback<LoginModel> {
    private Call searchCall;
    private ExampleContract.View mExampleContractView;

    public ExamplePresenter(ExampleContract.View view) {
        super(view);
        mExampleContractView = getView();
    }

    @Override
    public void onDataResponseFailed(String strRes) {
        mExampleContractView.showError(strRes);
    }

    @Override
    public void doLogin() {
        if (searchCall != null && !searchCall.isCanceled()) {
            // 如果有上一次的请求，并且没有取消，
            // 则调用取消请求操作
            searchCall.cancel();
        }
        searchCall = AccountHelper.doLogin("15695947865", "123456", this);
    }

    @Override
    public void onDataResponseSucceed(LoginModel loginModel) {
        mExampleContractView.onDoLoginSuccessful(loginModel);
    }
}
