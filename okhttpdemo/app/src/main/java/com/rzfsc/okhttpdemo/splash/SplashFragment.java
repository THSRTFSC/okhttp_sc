package com.rzfsc.okhttpdemo.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rzfsc.okhttpdemo.R;
import com.rzfsc.okhttpdemo.framework.BaseFragment;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/9.
 */

public class SplashFragment extends BaseFragment implements SplashContract.View {

    public SplashFragment() {}

    public static SplashFragment newInstance() {
        return new SplashFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void setPresenter(SplashContract.Presenter presenter) {
        // TODO
    }
}
