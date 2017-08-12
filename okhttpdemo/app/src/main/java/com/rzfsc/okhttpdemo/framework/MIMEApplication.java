package com.rzfsc.okhttpdemo.framework;

import android.app.Application;
import android.content.Context;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/12.
 */

public class MIMEApplication extends Application {

    private static MIMEApplication sMIMEApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
        sMIMEApplication = this;
    }

    public Context getMIMEApplicationContext() {
        return getApplicationContext();
    }

    public static MIMEApplication getInstance() {
        return sMIMEApplication;
    }
}
