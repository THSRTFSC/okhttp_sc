package com.rzfsc.mine.service.user;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rzfsc.mine.R;
import com.rzfsc.mine.db.entity.User;
import com.rzfsc.mine.framework.BaseFragment;
import com.rzfsc.mine.framework.MINEApplication;

/**
 * <p>
 *     用户个人页面
 * </p>
 * Created by augusting1991@163.com on 2017/8/12.
 */
public class UserProfileFragment extends LifecycleFragment implements UserProfileContract.View {

    private static final String TAG = "UserProfileFragment";

    private static final String UID_KEY = "uid";

    private UserProfileViewModel mViewModel;

    private UserProfileContract.Presenter mPresenter;

    public UserProfileFragment() {}

    public static UserProfileFragment newInstance() {
        return new UserProfileFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        String userId = getArguments().getString(UID_KEY);
//        mViewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);
//        mViewModel.init(userId);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View userProfile = inflater.inflate(R.layout.fragment_user_profile, container, false);
        UserProfileViewModel.Factory factory = new UserProfileViewModel.Factory(MINEApplication.getInstance(), 1);
        mViewModel = ViewModelProviders.of(this, factory).get(UserProfileViewModel.class);
        if (mViewModel != null) {
            mViewModel.getObservableUser().observe(this, new Observer<User>() {
                @Override
                public void onChanged(@Nullable User user) {
                    Log.d(TAG, "User data changed");
                }
            });
        }

        return userProfile;
    }

    @Override
    public void setPresenter(UserProfileContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

}
