package com.rzfsc.mine.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.rzfsc.mine.db.dao.UserDao;
import com.rzfsc.mine.db.entity.User;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/9/14.
 */

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    static final String DATABASE_NAME = "mine_db";

    public abstract UserDao mUserDao();
}