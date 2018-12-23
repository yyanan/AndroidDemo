package com.example.myapputils.base.activity;

import com.example.myapputils.base.presenter.BasePresenter;

public abstract class BaseActivity<V,P extends BasePresenter<V>>  extends SimpleActivity {
    public P presenter;
    @Override
    protected void initData() {
        presenter=createPresenter();
        if (presenter != null) {
            presenter.attachView((V) this);
        }
    }

    //创建子类的P层对象
    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
            presenter=null;
        }
    }
}
