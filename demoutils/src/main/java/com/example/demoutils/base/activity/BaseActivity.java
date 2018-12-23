package com.example.demoutils.base.activity;

import com.example.demoutils.base.presenter.BasePresenter;

public abstract class BaseActivity<V,P extends BasePresenter<V>> extends SimpleActivity {

    public P presenter;

    @Override
    public void viewCreated() {
        super.viewCreated();
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView((V) this);
        }
    }

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
