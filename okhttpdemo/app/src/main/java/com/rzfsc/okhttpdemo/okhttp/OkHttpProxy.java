package com.rzfsc.okhttpdemo.okhttp;

import android.util.Log;

import com.rzfsc.okhttpdemo.entity.APIResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

/**
 * Copyright(c) 2016. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/7/29.
 */

public class OkHttpProxy {

    private static OkHttpClient mInstance = null;

    static {
        mInstance =
                new OkHttpClient.Builder()
                        .connectTimeout(OkHttpConstants.HTTP_REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
                        .build();
    }

    private OkHttpProxy() {}

    /**
     *
     * @param url URL
     * @return {@link APIResult}
     */
    public static APIResult<JSONObject> doGet(String url) {
        Request request = new Request.Builder().url(url).build();
        try (Response response = mInstance.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseText = response.body().string();
                responseText = responseText.replace("{", "[").replace("}", "]");
                responseText = "{" + responseText.substring(1, responseText.length() - 1) + "}";
                Log.d(TAG, "doOkHttpRequest: response = " + responseText);
                JSONObject jsonObject = new JSONObject(responseText);
                return new APIResult<>(
                        OkHttpConstants.HTTP_REQUEST_RETURN_CODE_SUCCESS,
                        OkHttpConstants.HTTP_REQUESET_SUCCESS_ERROR_MESSAGE,
                        jsonObject);
            }
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param url URL
     * @param responseCallback Response Callback
     */
    public static void doGet(String url, Callback responseCallback) {
        Request request = new Request.Builder().url(url).build();
        mInstance.newCall(request).enqueue(responseCallback);
    }

    /**
     *
     * @param url URL
     * @param paramJson Request Params
     * @return {@link APIResult}
     */
    public static APIResult<JSONObject> doPost(String url, String paramJson) {
        RequestBody body = RequestBody.create(OkHttpConstants.JSON, paramJson);
        Request request = new Request.Builder().url(url).post(body).build();
        try (Response response = mInstance.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseText = response.body().string();
                Log.d(TAG, "doOkHttpRequest: response = " + responseText);
                return new APIResult<>(
                        OkHttpConstants.HTTP_REQUEST_RETURN_CODE_SUCCESS,
                        OkHttpConstants.HTTP_REQUESET_SUCCESS_ERROR_MESSAGE,
                        new JSONObject(responseText));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param url URL
     * @param paramJson Request Params
     * @param responseCallback {@link APIResult}
     */
    public static void doPost(String url, String paramJson, Callback responseCallback) {
        RequestBody body = RequestBody.create(OkHttpConstants.JSON, paramJson);
        Request request = new Request.Builder().url(url).post(body).build();
        mInstance.newCall(request).enqueue(responseCallback);
    }

    /**
     *
     * @param url URL
     * @param paramJson Request Params
     * @return {@link APIResult}
     */
    public static APIResult<JSONObject> doPut(String url, String paramJson) {
        RequestBody body = RequestBody.create(OkHttpConstants.JSON, paramJson);
        Request request = new Request.Builder().url(url).put(body).build();
        try (Response response = mInstance.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseText = response.body().string();
                Log.d(TAG, "doOkHttpRequest: response = " + responseText);
                return new APIResult<>(
                        OkHttpConstants.HTTP_REQUEST_RETURN_CODE_SUCCESS,
                        OkHttpConstants.HTTP_REQUESET_SUCCESS_ERROR_MESSAGE,
                        new JSONObject(responseText));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param url URL
     * @param paramJson Request Params
     * @param responseCallback {@link APIResult}
     */
    public static void doPut(String url, String paramJson, Callback responseCallback) {
        RequestBody body = RequestBody.create(OkHttpConstants.JSON, paramJson);
        Request request = new Request.Builder().url(url).put(body).build();
        mInstance.newCall(request).enqueue(responseCallback);
    }

}
