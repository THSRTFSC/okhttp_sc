package com.rzfsc.mine.module.todo;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.rzfsc.mine.R;
import com.rzfsc.mine.db.entity.Todo;
import com.rzfsc.mine.framework.MINEApplication;
import com.rzfsc.mine.framework.base.BaseFragment;
import com.rzfsc.mine.utils.DateUtils;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/10/7.
 */

public class TodoFragment extends BaseFragment implements TodoContract.View {


    private static final String TAG = "TodoFragment";

    private ListView mListView;

    private TodoViewModel mTodoViewModel;

    private TodoContract.Presenter mPresenter;

    public TodoFragment() {}

    public static TodoFragment newInstance() {
        return new TodoFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String todoDate = DateUtils.getTodayDateString();
        mTodoViewModel = ViewModelProviders.of(this).get(TodoViewModel.class);
        mTodoViewModel.init(todoDate);
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
        mListView = view.findViewById(R.id.todo_list);
        mListView.setAdapter(new TodoListAdapter());
        return view;
    }

    @Override
    public void setPresenter(TodoContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void initViewModel() {
        Log.d(TAG, "initViewModel() called");
    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void refreshUI() {
        Log.d(TAG, "refreshUI() called");
    }

    private static class TodoListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View contentView, ViewGroup container) {
            if (contentView == null) {
                contentView = LayoutInflater
                        .from(MINEApplication.getInstance().getMIMEAppContext())
                        .inflate(R.layout.fragment_todo_list_item, container, false);
            }
            return contentView;
        }
    }
}
