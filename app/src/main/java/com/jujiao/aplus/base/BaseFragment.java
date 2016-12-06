package com.jujiao.aplus.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    protected Activity mActivity;

    //初始化data
    protected abstract void initData();
    //初始化view
    protected abstract void initView(View view, Bundle savedInstanceState);
    //获取布局文件id
    protected abstract int setLayoutId();

    //获取宿主Activity
    protected Activity getHoldingActivity() {
        return mActivity;
    }

    @Override
    public void onAttach(Context context) {
        this.mActivity = (Activity) context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(setLayoutId(), container, false);
        ButterKnife.bind(this, view);
        initData();
        initView(view, savedInstanceState);
        return view;
    }

    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";
    //http://www.jianshu.com/p/c12a98a36b2b
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            boolean issupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (issupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commit();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }

    @Override
    public void onResume() {
        super.onResume();
        //友盟统计
        MobclickAgent.onPageStart(this.getClass().getSimpleName());
    }

    @Override
    public void onPause() {
        super.onPause();
        //友盟统计
        MobclickAgent.onPageEnd(this.getClass().getSimpleName());
    }
}
