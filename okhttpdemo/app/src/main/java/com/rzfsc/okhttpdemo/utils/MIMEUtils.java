package com.rzfsc.okhttpdemo.utils;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/22.
 */

public class MIMEUtils {

    private MIMEUtils() {

    }

    public static boolean checkParams(String strParams) {
        return !(strParams == null || strParams.length() <= 0);
    }

}
