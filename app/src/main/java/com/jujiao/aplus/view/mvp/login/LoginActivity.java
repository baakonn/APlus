package com.jujiao.aplus.view.mvp.login;


import com.jujiao.aplus.R;
import com.jujiao.aplus.base.BaseActivity;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    // mLoginPresenter
    private LoginContract.Presenter mLoginPresenter;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mLoginPresenter.login("test", "test");
    }

    @Override
    public void loginSuccess(String user) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void showTip(String message) {

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.mLoginPresenter = presenter;
    }
}
