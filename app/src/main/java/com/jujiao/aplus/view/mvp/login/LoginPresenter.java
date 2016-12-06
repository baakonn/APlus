package com.jujiao.aplus.view.mvp.login;

import android.text.TextUtils;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

public class LoginPresenter implements LoginContract.Presenter {

    private final LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void login(String username, String password) {
        if (TextUtils.isEmpty(username)) {
            view.showTip("用户名不能为空");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            view.showTip("密码不能为空");
            return;
        }

        view.showProgress();
        //请求网络
        OkHttpUtils.get().url("url")
                .addParams("name", "test")
                .addParams("pwd", "test")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                        view.dismissProgress();
                        view.loginSuccess("loadFail");
                    }

                    @Override
                    public void onResponse(String response, int id) {

                        view.dismissProgress();
                        view.loginSuccess("onResponse");
                    }
                });


    }
}
