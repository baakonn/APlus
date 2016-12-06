package com.jujiao.aplus.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

import com.jujiao.aplus.R;

import butterknife.ButterKnife;

/**
 * BaseActivity 2016-11-25
 */
public abstract class BaseSwipBackActivity extends SwipeBackAppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseConfig();
        setContentView(setLayout());

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
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        this.overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        this.overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
    }

    @Override
    public void finish() {
        super.finish();
        this.overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
    }

    //初始化view
    protected abstract void initView();
    //初始化data
    protected abstract void initData();
    //获取布局文件id
    protected abstract int setLayout();
}