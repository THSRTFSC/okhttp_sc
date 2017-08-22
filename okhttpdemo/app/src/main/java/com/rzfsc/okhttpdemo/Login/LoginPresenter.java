package com.rzfsc.okhttpdemo.Login;

import android.text.TextUtils;
import android.widget.TextView;

import okhttp3.Callback;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/13.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;

    private boolean mNetConnected = false;

    public LoginPresenter(LoginContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        // TODO
    }

    @Override
    public boolean inputVerification(int inputType, String inputValue) {
        if (TextUtils.isEmpty(inputValue)) {
            return false;
        }
        switch (inputType) {
            case LoginContract.INPUT_TYPE_USER_ACCOUNT:
                break;
            case LoginContract.INPUT_TYPE_USER_PASSWORD:
                break;
        }
    }

    @Override
    public void login(String userAccount, String userPwd, Callback callback) {
        // TODO
    }

}
