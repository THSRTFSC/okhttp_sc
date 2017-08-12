package com.rzfsc.okhttpdemo.splash;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rzfsc.okhttpdemo.MainActivity;
import com.rzfsc.okhttpdemo.framework.MIMEApplication;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/9.
 */

public class SplashPresenter implements SplashContract.Presenter {

    private SplashContract.View mView;

    public SplashPresenter(SplashContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        startAnimation();
    }

    private void startAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(getObjectAnimator(((SplashFragment)mView).getLogo(), "alpha"));
        animatorSet.play(getObjectAnimator(((SplashFragment)mView).getDescribe(), "alpha"));
        animatorSet.setDuration(2000);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startMIMEActivity();
            }
        });
        animatorSet.start();
    }

    private void startMIMEActivity() {
        Intent intent = new Intent();
        intent.setClass(MIMEApplication.getInstance().getMIMEApplicationContext(), MainActivity.class);
        if (mView instanceof Fragment) {
            SplashActivity splashActivity = (SplashActivity) ((Fragment) mView).getActivity();
            splashActivity.startActivity(intent);
            splashActivity.finish();
        }
    }

    private ObjectAnimator getObjectAnimator(View view, String property) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, property, 0, 1);
        return objectAnimator;
    }

}
