package com.rzfsc.mine.module.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.rzfsc.mine.R;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/9.
 */

public class LoginFragment extends Fragment implements LoginContract.View, View.OnClickListener {

    private LoginContract.Presenter mPresenter;

    private EditText mUserAccountEdit;

    private EditText mPasswordEdit;


    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View login = inflater.inflate(R.layout.fragment_login, container, false);
        init(login);
        return login;
    }

    private void init(View login) {
        mUserAccountEdit = (EditText) login.findViewById(R.id.et_user_account);
        mUserAccountEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mPasswordEdit = (EditText) login.findViewById(R.id.et_password);
        mPasswordEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Button loginBtn = (Button) login.findViewById(R.id.btn_login);
        loginBtn.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId) {
            case R.id.btn_login:
                String userAccount = mUserAccountEdit.getEditableText().toString();
                String password = mPasswordEdit.getEditableText().toString();
                mPresenter.login(userAccount, password);
                break;
        }
    }

    @Override
    public void finished() {
        getActivity().finish();
    }

    @Override
    public void clearInputValue() {
        mUserAccountEdit.setText("");
        mPasswordEdit.setText("");
    }
}
