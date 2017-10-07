package com.rzfsc.mine.module.todo;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/10/7.
 */

public class TodoPresenter implements TodoContract.Presenter {

    private TodoContract.View mView;

    public TodoPresenter(TodoContract.View view) {
        this.mView = view;
    }


    @Override
    public void start() {

    }
}
