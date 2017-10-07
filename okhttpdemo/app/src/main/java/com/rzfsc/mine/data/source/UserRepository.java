package com.rzfsc.mine.data.source;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.rzfsc.mine.db.entity.User;
import com.rzfsc.mine.module.user.WebService;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 数据仓库
 * Created by augusting1991@163.com on 2017/8/12.
 */

public class UserRepository {

    private static final String TAG = "UserRepository";
    
    private WebService mWebService;

    public LiveData<User> getUser(String userId) {
        final MutableLiveData<User> data = new MutableLiveData<>();
        mWebService.getUser(userId).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse: ");
            }
        });
        return data;
    }
}
