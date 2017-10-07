package com.rzfsc.mine.module.todo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rzfsc.mine.R;
import com.rzfsc.mine.db.entity.Todo;
import com.rzfsc.mine.framework.base.BaseFragment;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/10/7.
 */

public class TodoFragment extends BaseFragment implements TodoContract.View {


    private static final String TAG = "TodoFragment";

    private static final String TODO_ID_KEY = "todo_id";

    private TodoViewModel mTodoViewModel;

    private TodoContract.Presenter mPresenter;

    public TodoFragment() {}

    public static TodoFragment newInstance() {
        return new TodoFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String todoId = getArguments().getString(TODO_ID_KEY);
        mTodoViewModel = ViewModelProviders.of(this).get(TodoViewModel.class);
        mTodoViewModel.init(todoId);
        mTodoViewModel.getTodo().observe(this, new Observer<Todo>() {
            @Override
            public void onChanged(@Nullable Todo todo) {
                Log.d(TAG, "onChanged() called with: todo = [" + todo + "]");
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todo, container, false);
        return view;
    }

    @Override
    public void setPresenter(TodoContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
