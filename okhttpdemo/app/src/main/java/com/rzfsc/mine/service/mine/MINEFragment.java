package com.rzfsc.mine.service.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rzfsc.mine.framework.BaseFragment;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/27.
 */

public class MINEFragment extends BaseFragment implements MINEContract.View{

    private MINEContract.Presenter mPresenter;

    public MINEFragment() {}

    public static MINEFragment newInstance() {
        return new MINEFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void setPresenter(MINEContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
