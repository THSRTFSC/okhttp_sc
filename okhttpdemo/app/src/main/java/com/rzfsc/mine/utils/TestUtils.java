package com.rzfsc.mine.utils;

import com.rzfsc.mine.db.entity.Todo;
import com.rzfsc.mine.db.entity.TodoItem;

import java.util.ArrayList;
import java.util.Date;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/10/8.
 */

public class TestUtils {

    public static Todo createTodo() {
        Todo todo = new Todo();
        todo.setStatus(0);
        todo.setContent("Test-Test");
        todo.setCreateTime(new Date());
        todo.setUpdateTime(new Date());
        todo.setTodoItems(new ArrayList<TodoItem>());
        todo.setDate("20171008");
        return todo;
    }
}
