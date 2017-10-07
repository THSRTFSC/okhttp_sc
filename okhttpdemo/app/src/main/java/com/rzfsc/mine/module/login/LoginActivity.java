package com.rzfsc.mine.module.login;

import android.util.Log;

import com.rzfsc.mine.R;
import com.rzfsc.mine.framework.base.BaseActivity;
import com.rzfsc.mine.utils.ActivityUtils;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/9.
 */

public class LoginActivity extends BaseActivity {

    private static final String TAG = "LoginActivity";

    @Override
    public void setFragment() {
        Log.d(TAG, "setFragment: add fragment");
        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        if (loginFragment == null) {
            loginFragment = LoginFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), loginFragment, R.id.fragment);
        }
        new LoginPresenter(loginFragment);
    }
}
