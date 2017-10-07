package com.rzfsc.mine.module.user;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/9/3.
 */

public class UserProfilePresenter implements UserProfileContract.Presenter {

    private UserProfileContract.View mView;

    public UserProfilePresenter(UserProfileContract.View view) {
        this.mView = view;
    }


    @Override
    public void start() {

    }
}
