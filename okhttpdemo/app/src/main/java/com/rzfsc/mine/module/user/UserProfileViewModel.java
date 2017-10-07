package com.rzfsc.mine.module.user;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.rzfsc.mine.db.DatabaseCreator;
import com.rzfsc.mine.db.entity.User;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/9/3.
 */

public class UserProfileViewModel extends AndroidViewModel {

    private static final MutableLiveData ABSENT = new MutableLiveData();
    {
        //noinspection unchecked
        ABSENT.setValue(null);
    }

    private int mUserId;

    private LiveData<User> mUserLiveData;


    public UserProfileViewModel(Application application, int userId) {
        super(application);
        this.mUserId = userId;
        final DatabaseCreator databaseCreator = DatabaseCreator.getInstance(this.getApplication());


        mUserLiveData = Transformations.switchMap(databaseCreator.isDatabaseCreated(), new Function<Boolean, LiveData<User>>() {
            @Override
            public LiveData<User> apply(Boolean isDbCreated) {
                if (!isDbCreated) {
                    //noinspection unchecked
                    return ABSENT;
                } else {
                    //noinspection ConstantConditions
                    return databaseCreator.getDatabase().mUserDao().load(mUserId);
                }
            }
        });

        databaseCreator.createDb(this.getApplication());
    }

    public LiveData<User> getObservableUser() {
        return mUserLiveData;
    }

    /**
     * A creator is used to inject the product ID into the ViewModel
     * <p>
     * This creator is to showcase how to inject dependencies into ViewModels. It's not
     * actually necessary in this case, as the product ID can be passed in a public method.
     */
    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application mApplication;

        private final int mUserId;

        public Factory(@NonNull Application application, int userId) {
            mApplication = application;
            mUserId = userId;
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new UserProfileViewModel(mApplication, mUserId);
        }
    }
}
