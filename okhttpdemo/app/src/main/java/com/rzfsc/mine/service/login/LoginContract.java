package com.rzfsc.mine.service.login;

import com.rzfsc.mine.framework.BasePresenter;
import com.rzfsc.mine.framework.BaseView;

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
