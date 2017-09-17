package com.rzfsc.mine.service.splash;

import android.util.Log;

import com.rzfsc.mine.R;
import com.rzfsc.mine.framework.BaseActivity;
import com.rzfsc.mine.utils.ActivityUtils;

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
