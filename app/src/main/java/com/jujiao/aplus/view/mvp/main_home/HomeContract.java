package com.jujiao.aplus.view.mvp.main_home;

import com.jujiao.aplus.base.BasePresenter;
import com.jujiao.aplus.base.BaseView;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface HomeContract {

    interface View extends BaseView<Presenter> {
        void loadFirstOk(Object o);
        void loadFail(String message);

    }

    interface Presenter extends BasePresenter {
        void loadFirst();
    }
}
