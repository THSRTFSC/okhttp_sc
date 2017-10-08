package com.rzfsc.mine.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;
import java.util.List;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/10/7.
 */

@Entity(tableName = "todo", indices = {@Index(value = "date", unique = true)})
public class Todo {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private long mId;

    @ColumnInfo(name = "status")
    private int mStatus;

    @ColumnInfo(name = "create_time")
    private Date mCreateTime;

    @ColumnInfo(name = "update_time")
    private Date mUpdateTime;

    @ColumnInfo(name = "date")
    private String mDate;

    @ColumnInfo(name = "content")
    private String mContent;

    @Ignore
    private List<TodoItem> mTodoItems;

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int status) {
        mStatus = status;
    }

    public Date getCreateTime() {
        return mCreateTime;
    }

    public void setCreateTime(Date createTime) {
        mCreateTime = createTime;
    }

    public Date getUpdateTime() {
        return mUpdateTime;
    }

    public void setUpdateTime(Date updateTime) {
        mUpdateTime = updateTime;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public List<TodoItem> getTodoItems() {
        return mTodoItems;
    }

    public void setTodoItems(List<TodoItem> todoItems) {
        mTodoItems = todoItems;
    }
}
