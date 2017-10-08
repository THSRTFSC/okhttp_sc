package com.rzfsc.mine;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.rzfsc.mine.db.AppDatabase;
import com.rzfsc.mine.db.dao.TodoDao;
import com.rzfsc.mine.db.entity.Todo;
import com.rzfsc.mine.utils.TestUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/10/8.
 */
@RunWith(AndroidJUnit4.class)
public class DatabaseTest {

    @RunWith(AndroidJUnit4.class)
    public class SimpleEntityReadWriteTest {
        private TodoDao mTodoDao;
        private AppDatabase mDb;

        @Before
        public void createDb() {
            Context context = InstrumentationRegistry.getTargetContext();
            mDb = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
            mTodoDao = mDb.getTodoDao();
        }

        @After
        public void closeDb() throws IOException {
            mDb.close();
        }

        @Test
        public void writeUserAndReadInList() throws Exception {
            Todo todo = TestUtils.createTodo();
            mTodoDao.insert(todo);
            LiveData<Todo> todoLiveData = mTodoDao.findByDate("20171008");
            assertThat(todoLiveData.getValue().getDate(), equalTo("20171008"));
        }
    }
}
