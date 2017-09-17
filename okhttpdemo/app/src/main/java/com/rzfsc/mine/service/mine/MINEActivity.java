package com.rzfsc.mine.service.mine;

import android.util.Log;

import com.rzfsc.mine.R;
import com.rzfsc.mine.framework.BaseActivity;
import com.rzfsc.mine.utils.ActivityUtils;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/13.
 */

public class MINEActivity extends BaseActivity {

    private String TAG = "MINEActivity";

    @Override
    public void setFragment() {
        Log.d(TAG, "setFragment: add fragment");
        MINEFragment mimeFragment = (MINEFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        if (mimeFragment == null) {
            mimeFragment = MINEFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mimeFragment, R.id.fragment);
        }
        new MINEPresenter(mimeFragment);
    }
}
