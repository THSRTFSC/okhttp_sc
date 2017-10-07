package com.rzfsc.mine.module.mine;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/27.
 */

public class MINEPresenter implements MINEContract.Presenter {

    private MINEContract.View mView;

    public MINEPresenter(MINEContract.View view) {
        this.mView = view;
    }

    @Override
    public void start() {

    }
}
