package com.jujiao.aplus.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;

/**
 * BaseActivity 2016-11-25
 */
public abstract class BaseActivity extends Activity {
    //初始化data
    protected abstract void initData();
    //初始化view
    protected abstract void initView();
    //获取布局文件id
    protected abstract int setLayoutId();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseConfig();
        setContentView(setLayoutId());
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void setBaseConfig() {
//        initTheme();
        AppManager.getAppManager().addActivity(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        SetStatusBarColor();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //友盟统计
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //友盟统计
        MobclickAgent.onPause(this);
    }

}