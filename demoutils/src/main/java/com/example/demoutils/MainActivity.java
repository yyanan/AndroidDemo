package com.example.demoutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.demoutils.base.activity.BaseActivity;
import com.example.demoutils.beans.zhihu.DailyListBean;
import com.example.demoutils.presenter.ZhihuPresenter;
import com.example.demoutils.view.ZhuhuView;

import java.util.logging.Logger;

public class MainActivity extends BaseActivity<ZhuhuView,ZhihuPresenter<ZhuhuView>> implements ZhuhuView {


    @Override
    protected ZhihuPresenter<ZhuhuView> createPresenter() {
        return new ZhihuPresenter<>();
    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        presenter.getDailyListBean();
    }

    @Override
    public void show(DailyListBean dailyListBean) {
        Logger.getLogger(dailyListBean.toString());
        Log.e("mand",dailyListBean.toString());
    }

    @Override
    public void showProgressbar() {

    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showError(String error) {

    }
}
