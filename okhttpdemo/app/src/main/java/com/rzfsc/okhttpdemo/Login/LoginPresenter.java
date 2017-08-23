package com.rzfsc.okhttpdemo.Login;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.rzfsc.okhttpdemo.R;
import com.rzfsc.okhttpdemo.framework.MIMEApplication;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/13.
 */

public class LoginPresenter implements LoginContract.Presenter, Callback {

    private static final int MAX_LENGTH_PASSWORD = 20;

    private static final int MIN_LENGTH_PASSWORD = 16;

    private static final int MAX_LENGTH_USER_ACCOUNT = 8;

    private static final String TAG = "LoginPresenter";

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
        int valueLength = inputValue.length();
        switch (inputType) {
            case LoginContract.INPUT_TYPE_USER_ACCOUNT:
                if (valueLength < MAX_LENGTH_USER_ACCOUNT) {
                    Toast.makeText(MIMEApplication.getInstance(), R.string.account_not_longer_enough, Toast.LENGTH_LONG).show();
                }
                break;
            case LoginContract.INPUT_TYPE_USER_PASSWORD:

                if (MIN_LENGTH_PASSWORD <= valueLength && valueLength <= MAX_LENGTH_PASSWORD) {
                    Toast.makeText(MIMEApplication.getInstance(), R.string.password_not_longer_enough, Toast.LENGTH_LONG).show();
                }
                break;
        }
        return false;
    }

    @Override
    public void login(String userAccount, String userPwd) {
        if (inputVerification(LoginContract.INPUT_TYPE_USER_ACCOUNT, userAccount)
                && inputVerification(LoginContract.INPUT_TYPE_USER_PASSWORD, userPwd)) {
            login(userAccount, userPwd, this);
        }
    }

    private void login(String userAccount, String userPwd, Callback callback) {
        Log.d(TAG, "login() called with: userAccount = [" + userAccount + "], userPwd = [" + userPwd + "], callback = [" + callback + "]");
    }

    @Override
    public void onFailure(Call call, IOException e) {
        // TODO
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        // TODO
    }
}
