package com.example.demoutils.base.activity;

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
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(createLayoutId());
        bind= ButterKnife.bind(this);
        activity=this;
        viewCreated();
        initData();
    }

    protected abstract int createLayoutId();

    protected abstract void initData();

    void viewCreated() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind!=null){
            bind.unbind();
        }
    }
}
