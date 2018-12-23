package com.example.demoutils.presenter;

import com.example.demoutils.base.presenter.IBasePresenter;
import com.example.demoutils.beans.zhihu.DailyListBean;
import com.example.demoutils.moudle.ZhihuModule;
import com.example.demoutils.view.ZhuhuView;

public class ZhihuPresenter<V extends ZhuhuView> extends IBasePresenter<V> implements ZhihuModule.ZHihuCallBack {

    private ZhihuModule zhihuModule=new ZhihuModule();

    public void getDailyListBean() {
        if (mView != null) {
            zhihuModule.getDailyListBean(this);
        }
    }
    @Override
    public void setDailyListBean(DailyListBean data) {
        if (mView != null) {
            mView.show(data);
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
}
