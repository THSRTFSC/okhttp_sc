package com.rzfsc.mine;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.test.AndroidTestCase;

import com.rzfsc.mine.db.AppDatabase;
import com.rzfsc.mine.db.dao.TodoDao;
import com.rzfsc.mine.db.entity.Todo;
import com.rzfsc.mine.utils.TestUtils;

import org.junit.Test;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/10/8.
 */

public class DatabaseUnitTest extends AndroidTestCase {

    private TodoDao mTodoDao;
    private AppDatabase mDb;

    @Test
    public void writeUserAndReadInList() throws Exception {
        mDb = Room.inMemoryDatabaseBuilder(getContext(), AppDatabase.class).build();
        mTodoDao = mDb.getTodoDao();

        Todo todo = TestUtils.createTodo();
        mTodoDao.insert(todo);
        LiveData<Todo> todoLiveData = mTodoDao.findByDate("20171009");
        assertEquals(true, todoLiveData != null);
        mDb.close();
    }
}
