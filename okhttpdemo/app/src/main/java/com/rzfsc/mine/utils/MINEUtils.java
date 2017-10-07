package com.rzfsc.mine.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/22.
 */

public class MINEUtils {

    private MINEUtils() {

    }

    public static boolean checkParams(String strParams) {
        return !(strParams == null || strParams.length() <= 0);
    }

    public static void close(InputStream stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(OutputStream stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
