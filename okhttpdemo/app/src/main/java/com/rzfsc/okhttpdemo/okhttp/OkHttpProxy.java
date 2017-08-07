package com.rzfsc.okhttpdemo.okhttp;

import android.util.Log;

import com.rzfsc.okhttpdemo.entity.APIResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

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
                        .connectTimeout(OkHttpConstants.HTTP_REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
                        .build();
    }

    private OkHttpProxy() {}

    public static APIResult doGet(String url) {
        Request request = new Request.Builder().url(url).build();
        try {
            try (Response response = mInstance.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    String responseText = response.body().string();
                    responseText = responseText.replace("{", "[").replace("}", "]");
                    responseText = "{" + responseText.substring(1, responseText.length() - 1) + "}";
                    Log.d(TAG, "doOkHttpRequest: response = " + responseText);
                    JSONObject jsonObject = new JSONObject(responseText);
                    return new APIResult(
                            OkHttpConstants.HTTP_REQUEST_RETURN_CODE_SUCCESS,
                            OkHttpConstants.HTTP_REQUESET_SUCCESS_ERROR_MESSAGE,
                            jsonObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static APIResult doPost() {
        // TODO
        return new APIResult(0, "", null);
    }

    public static APIResult doPut() {
        // TODO
        return new APIResult(0, "", null);
    }

}
