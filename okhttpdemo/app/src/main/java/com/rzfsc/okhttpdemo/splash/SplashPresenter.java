package com.rzfsc.okhttpdemo.splash;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/9.
 */

public class SplashPresenter implements SplashContract.Presenter {

    private SplashContract.View mView;

    public SplashPresenter(SplashContract.View view) {
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        // TODO
    }
}
