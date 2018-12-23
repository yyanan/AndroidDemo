package com.example.myapputils.base.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class SimpleActivity extends AppCompatActivity {

    public Activity activity;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(createLayoutId());
        bind = ButterKnife.bind(this);
        activity = this;

        viewCreated();
        initData();
    }

    //初始化数据
    protected abstract void initData();
//初始化布局
    public abstract int createLayoutId();

    private void viewCreated() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(bind!=null){
            bind.unbind();
        }
    }
}
