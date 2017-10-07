package com.rzfsc.mine.framework;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.rzfsc.mine.db.AppDatabase;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/12.
 */

public class MINEApplication extends Application {

    private static MINEApplication sMIMEApplication = null;

    private String mLoginToken = "";

    @Override
    public void onCreate() {
        super.onCreate();
        sMIMEApplication = this;
    }

    public Context getMIMEApplicationContext() {
        return getApplicationContext();
    }

    public static MINEApplication getInstance() {
        return sMIMEApplication;
    }

    public String getLoginToken() {
        return mLoginToken;
    }

    public void setLoginToken(String loginToken) {
        mLoginToken = loginToken;
    }

}
