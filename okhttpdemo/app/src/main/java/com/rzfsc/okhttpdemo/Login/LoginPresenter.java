package com.rzfsc.okhttpdemo.Login;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.rzfsc.okhttpdemo.R;
import com.rzfsc.okhttpdemo.constants.Constants;
import com.rzfsc.okhttpdemo.entity.APIResult;
import com.rzfsc.okhttpdemo.framework.MIMEApplication;
import com.rzfsc.okhttpdemo.okhttp.OkHttpProxy;
import com.rzfsc.okhttpdemo.utils.JsonUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    private static final String PARAM_KEY_USER_ACCOUNT = "userAccount";

    private static final String PARAM_KEY_USER_PASSWORD = "userPwd";

    private static final String TAG = "LoginPresenter";

    private LoginContract.View mView;

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
                    return false;
                }
                break;
            case LoginContract.INPUT_TYPE_USER_PASSWORD:
                if (MIN_LENGTH_PASSWORD >= valueLength || valueLength >= MAX_LENGTH_PASSWORD) {
                    Toast.makeText(MIMEApplication.getInstance(), R.string.password_not_longer_enough, Toast.LENGTH_LONG).show();
                    return false;
                }
                break;
        }
        return true;
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
        Map params = new HashMap();
        params.put(PARAM_KEY_USER_ACCOUNT, userAccount);
        params.put(PARAM_KEY_USER_PASSWORD, userPwd);
        OkHttpProxy.doPost(Constants.URL_LOGIN, JsonUtils.toJson(params), callback);
    }

    @Override
    public void onFailure(Call call, IOException e) {
        Log.d(TAG, "onFailure() called with: call = [" + call + "], e = [" + e + "]");
        mView.clearInputValue();
        Toast.makeText(MIMEApplication.getInstance(), R.string.login_fail, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        String responseString = response.body().string();
        APIResult apiResult = (APIResult) JsonUtils.toObject(responseString, APIResult.class);
        try {
            String loginToken = new JSONObject(apiResult.getBody().toString()).getString("token");
            MIMEApplication.getInstance().setLoginToken(loginToken);
            Log.d(TAG, "onResponse: " + loginToken);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "onResponse() called with: call = [" + call + "], response = [" + responseString + "]");
        mView.finished();
    }
}
