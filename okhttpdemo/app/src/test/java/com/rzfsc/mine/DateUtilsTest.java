package com.rzfsc.mine;

import com.rzfsc.mine.utils.DateUtils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/10/8.
 */

public class DateUtilsTest {

    @Test
    public void testGetTodayDateString() {
        String todayDateString = DateUtils.getTodayDateString();
        assertEquals(true, todayDateString.equals("20171008"));
    }
}
