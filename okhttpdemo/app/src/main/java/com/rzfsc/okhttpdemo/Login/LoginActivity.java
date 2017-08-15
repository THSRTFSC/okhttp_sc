package com.rzfsc.okhttpdemo.Login;

import android.util.Log;

import com.rzfsc.okhttpdemo.R;
import com.rzfsc.okhttpdemo.framework.BaseActivity;
import com.rzfsc.okhttpdemo.utils.ActivityUtils;

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
