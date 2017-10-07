package com.rzfsc.mine.module.todo;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.rzfsc.mine.db.entity.Todo;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/10/7.
 */

public class TodoViewModel extends AndroidViewModel {

    private LiveData<Todo> mTodo;

    private TodoRepository mTodoRepository;

    public TodoViewModel(Application application) {
        super(application);
    }

    public LiveData<Todo> getTodo() {
        return mTodo;
    }

    public void init(String todoId) {
        if (mTodo != null) {
            return;
        }
        mTodo = mTodoRepository.getTodo(todoId);
    }
}
