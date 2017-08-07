package com.rzfsc.okhttpdemo.utils;

import com.rzfsc.okhttpdemo.constants.Constants;
import com.rzfsc.okhttpdemo.entity.APIResult;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Copyright(c) 2016. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/7/29.
 */

public class OkHttpProxy<T> {

    private static OkHttpClient mInstance = null;

    static {
        mInstance =
                new OkHttpClient.Builder()
                        .connectTimeout(Constants.HTTP_REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
                        .build();
    }

    private OkHttpProxy() {}

    public static APIResult doGet(String url) {
        // TODO
        return new APIResult() ;
    }

    public static APIResult doPost() {
        // TODO
        return new APIResult();
    }

    public static APIResult doPut() {
        // TODO
        return new APIResult();
    }

}
