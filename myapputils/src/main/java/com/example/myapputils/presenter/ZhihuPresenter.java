package com.example.myapputils.presenter;

import com.example.myapputils.base.presenter.BasePresenterIml;
import com.example.myapputils.beans.zhihu.DailyListBean;
import com.example.myapputils.module.ZhihuModule;
import com.example.myapputils.view.ZhihuView;

public class ZhihuPresenter<V extends ZhihuView> extends BasePresenterIml<V> implements ZhihuModule.ZHihuCallback {

    private ZhihuModule zhihuModule=new ZhihuModule();

    public void getDailyListBean() {
        if (mView != null) {
            zhihuModule.getDailyListBean(this);
        }
    }

    @Override
    public void setShowProgressbar() {

    }

    @Override
    public void setHideProgressbar() {

    }

    @Override
    public void setError(String error) {
        if (mView != null) {
            mView.showError(error);
        }
    }

    @Override
    public void setDailyListBean(DailyListBean data) {
        if (mView != null) {
            mView.show(data);
        }
    }
}
