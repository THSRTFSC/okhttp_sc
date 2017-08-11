package com.rzfsc.okhttpdemo.splash;

import android.util.Log;

import com.rzfsc.okhttpdemo.R;
import com.rzfsc.okhttpdemo.framework.BaseActivity;
import com.rzfsc.okhttpdemo.utils.ActivityUtils;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/9.
 */

public class SplashActivity extends BaseActivity {

    private static final String TAG = "SplashActivity";

    @Override
    public void setFragment() {
        Log.d(TAG, "setFragment: add fragment");
        SplashFragment splashFragment = (SplashFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        if (splashFragment == null) {
            splashFragment = SplashFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), splashFragment, R.id.fragment);
        }
        new SplashPresenter(splashFragment);
    }
}
