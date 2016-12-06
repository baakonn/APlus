package com.jujiao.aplus.view.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jujiao.aplus.R;
import com.jujiao.aplus.base.BaseFragment;

import butterknife.BindView;

public class FindFragment extends BaseFragment {
    @BindView(R.id.fragment_text)
    TextView mTextView;

    @Override
    protected void initData() {

    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mTextView.setText("我是FindFragment");
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_layout;
    }


}
