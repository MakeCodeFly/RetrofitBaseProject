package com.szhrnet.taoqiapp.view.home;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.szhrnet.taoqiapp.R;
import com.szhrnet.taoqiapp.base.BaseFragment;
import com.szhrnet.taoqiapp.mvp.contract.ExampleContract;
import com.szhrnet.taoqiapp.mvp.model.LoginModel;
import com.szhrnet.taoqiapp.mvp.presenter.ExamplePresenter;

//import butterknife.BindView;


/**
 * <pre>
 *     author: Zou Juequn
 *     desc  : 首页Fragment
 *     email:15695947865@139.com
 */

public class HomeFragment extends BaseFragment implements ExampleContract.View {
//    @BindView(R.id.textview)

    private TextView mTextView;

    private ExampleContract.Presenter mPresenter;

    @Override
    public int bindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View parentView) {
        mTextView = parentView.findViewById(R.id.textview2);
        mPresenter = new ExamplePresenter(this);
        mPresenter.doLogin();
    }


    @Override
    protected void initWidget(Bundle savedInstanceState) {

    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void showError(String str) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void setPresenter(ExampleContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onDoLoginSuccessful(LoginModel model) {
        mTextView.setText(model.getUserarr().getUser_nick());
    }
}
