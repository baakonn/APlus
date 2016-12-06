package com.jujiao.aplus.view.mvp.login;


import com.jujiao.aplus.base.BasePresenter;
import com.jujiao.aplus.base.BaseView;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface LoginContract {

    interface View extends BaseView<Presenter> {

        void loginSuccess(String user);

    }

    interface Presenter extends BasePresenter {

        void login(String username, String password);

    }
}
