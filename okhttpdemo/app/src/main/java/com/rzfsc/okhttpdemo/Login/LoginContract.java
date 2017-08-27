package com.rzfsc.okhttpdemo.Login;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.rzfsc.okhttpdemo.framework.BasePresenter;
import com.rzfsc.okhttpdemo.framework.BaseView;

import okhttp3.Callback;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/13.
 */

public interface LoginContract {

    int INPUT_TYPE_USER_ACCOUNT = 0;
    int INPUT_TYPE_USER_PASSWORD = 1;


    interface View extends BaseView<Presenter> {

        void finished();

        void clearInputValue();

    }

    interface Presenter extends BasePresenter {

        @Override
        void start();

        boolean inputVerification(int inputType, String inputValue);

        void login(String userAccount, String userPwd);
    }
}
