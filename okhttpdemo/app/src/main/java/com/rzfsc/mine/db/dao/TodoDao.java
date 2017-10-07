package com.rzfsc.mine.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.rzfsc.mine.db.entity.Todo;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/10/7.
 */

@Dao
public interface TodoDao {

    @Query("SELECT * FROM todo WHERE id = :todoId")
    LiveData<Todo> load(String todoId);

}
