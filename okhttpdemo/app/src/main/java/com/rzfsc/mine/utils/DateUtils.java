package com.rzfsc.mine.utils;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/10/8.
 */

public class DateUtils {

    private static final String TAG = "DateUtils";

    private static String DATE_PATTERN_yyyMMdd = "yyyyMMdd";

    private static SimpleDateFormat sSimpleDateFormat = new SimpleDateFormat();

    private DateUtils() {}



    public static String getTodayDateString() {
        Date today = new Date();
        sSimpleDateFormat.applyPattern(DATE_PATTERN_yyyMMdd);
        String todayDateString = sSimpleDateFormat.format(today);
        Log.d(TAG, "getTodayDateString: " + todayDateString);
        return todayDateString;
    }

}
