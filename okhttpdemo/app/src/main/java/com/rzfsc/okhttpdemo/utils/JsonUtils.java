package com.rzfsc.okhttpdemo.utils;

import com.google.gson.Gson;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/8.
 */

public class JsonUtils<T> {

    public static String toJson(Object o){
        return new Gson().toJson(o);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Object toObject(String vlaue, Class valueType) {
        return new Gson().fromJson(vlaue, valueType);
    }

}
