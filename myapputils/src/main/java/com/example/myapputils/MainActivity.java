package com.example.myapputils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.myapputils.base.activity.BaseActivity;
import com.example.myapputils.beans.zhihu.DailyListBean;
import com.example.myapputils.presenter.ZhihuPresenter;
import com.example.myapputils.view.ZhihuView;

import java.util.logging.Logger;

public class MainActivity extends BaseActivity<ZhihuView,ZhihuPresenter<ZhihuView>> implements ZhihuView {

    @Override
    protected void initData() {
      //  presenter.getDailyListBean();
    }

    @Override
    public int createLayoutId(){
        return R.layout.activity_main;
    }

    @Override
    protected ZhihuPresenter<ZhihuView> createPresenter() {
        return new ZhihuPresenter<>();
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
