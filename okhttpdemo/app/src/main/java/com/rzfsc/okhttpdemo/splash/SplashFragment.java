package com.rzfsc.okhttpdemo.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rzfsc.okhttpdemo.R;
import com.rzfsc.okhttpdemo.framework.BaseFragment;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/9.
 */

public class SplashFragment extends BaseFragment implements SplashContract.View {

    private SplashContract.Presenter mPresenter;

    private ImageView mLogo;

    private TextView mDescribe;

    public SplashFragment() {}

    public static SplashFragment newInstance() {
        return new SplashFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View splash = inflater.inflate(R.layout.fragment_splash, container, false);
        mLogo = (ImageView) splash.findViewById(R.id.iv_logo);
        mDescribe = (TextView) splash.findViewById(R.id.tv_inc);
        mDescribe.setText(getResources().getString(R.string.app_describe));
        return splash;
    }

    @Override
    public void setPresenter(SplashContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    public ImageView getLogo() {
        return mLogo;
    }

    public TextView getDescribe() {
        return mDescribe;
    }

}
