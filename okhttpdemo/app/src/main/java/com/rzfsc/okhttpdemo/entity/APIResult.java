package com.rzfsc.okhttpdemo.entity;

/**
 * Copyright(c) 2016. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/8/7.
 */

public class APIResult<T> {

    private int returnCode;

    private String stackTrace;

    private T body;

    public APIResult() {}

    public APIResult(int returnCode, String stackTrace) {
        super();
        this.returnCode = returnCode;
        this.stackTrace = stackTrace;
    }

    public APIResult(int returnCode, String errorMessage, T content) {
        this.returnCode = returnCode;
        this.stackTrace = errorMessage;
        this.body = content;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return APIResult.class.getSimpleName() +
                " : returnCode = [" + returnCode +
                "], content = [" + body.toString() + "]";
    }
}
