package com.rzfsc.mine.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * 用户数据结构
 * Created by augusting1991@163.com on 2017/8/12.
 */

@Entity(tableName = "user")
public class User {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "name")
    private String userName;

    @ColumnInfo(name = "mobile")
    private String userMobile;

    @ColumnInfo(name = "email")
    private String userEmail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
