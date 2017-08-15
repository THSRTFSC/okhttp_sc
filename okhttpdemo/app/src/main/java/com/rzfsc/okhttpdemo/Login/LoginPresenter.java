package com.rzfsc.okhttpdemo.Login;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/13.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;

    public LoginPresenter(LoginContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
