package com.rzfsc.okhttpdemo.Login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rzfsc.okhttpdemo.R;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/9.
 */

public class LoginFragment extends Fragment implements LoginContract.View {

    private LoginContract.Presenter mPresenter;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View login = inflater.inflate(R.layout.fragment_login, container, false);

        return login;
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
