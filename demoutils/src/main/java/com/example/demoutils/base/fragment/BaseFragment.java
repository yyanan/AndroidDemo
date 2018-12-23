package com.example.demoutils.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.demoutils.base.presenter.BasePresenter;

public abstract class BaseFragment<V,P extends BasePresenter<V>> extends SimpleFragment {

    public P presenter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter=createPresenter();
        if (presenter != null) {
            presenter.attachView((V) this);
        }
    }

    protected abstract P createPresenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.detachView();
            presenter=null;
        }
    }
}
