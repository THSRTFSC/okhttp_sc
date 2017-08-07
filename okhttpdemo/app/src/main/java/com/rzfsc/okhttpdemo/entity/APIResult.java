package com.rzfsc.okhttpdemo.entity;

/**
 * Copyright(c) 2016. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/7.
 */

public class APIResult<T> {

    private int mReturnCode;

    private String mErrorMessage;

    private T mContent;

    public int getReturnCode() {
        return mReturnCode;
    }

    public void setReturnCode(int returnCode) {
        mReturnCode = returnCode;
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        mErrorMessage = errorMessage;
    }

    public T getContent() {
        return mContent;
    }

    public void setContent(T content) {
        mContent = content;
    }

    @Override
    public String toString() {
        return APIResult.class.getSimpleName() +
                " : returnCode = [" + mReturnCode +
                "], content = [" + mContent.toString() + "]";
    }
}
