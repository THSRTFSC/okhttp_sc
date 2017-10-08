package com.rzfsc.mine.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.rzfsc.mine.db.entity.Todo;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/10/7.
 */

@Dao
public interface TodoDao {

    @Query("SELECT * FROM todo WHERE id = :todoId")
    LiveData<Todo> findById(String todoId);

    @Query("SELECT * FROM todo WHERE date = :date")
    LiveData<Todo> findByDate(String date);

    @Query("SELECT * FROM todo")
    LiveData<List<Todo>> getAll();

    @Insert(onConflict = REPLACE)
    void insert(Todo todo);

}
