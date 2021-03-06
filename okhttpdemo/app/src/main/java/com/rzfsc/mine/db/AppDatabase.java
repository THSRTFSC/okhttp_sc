package com.rzfsc.mine.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.rzfsc.mine.db.converter.DateConverter;
import com.rzfsc.mine.db.dao.TodoDao;
import com.rzfsc.mine.db.dao.UserDao;
import com.rzfsc.mine.db.entity.Todo;
import com.rzfsc.mine.db.entity.User;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/9/14.
 */

@Database(entities = {User.class, Todo.class}, version = 1, exportSchema = false)
@TypeConverters({DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    static final String DATABASE_NAME = "mine_db";

    public abstract UserDao getUserDao();

    public abstract TodoDao getTodoDao();
}
