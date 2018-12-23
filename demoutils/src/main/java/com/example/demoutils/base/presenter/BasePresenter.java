package com.example.demoutils.base.presenter;

public interface BasePresenter<V> {
    void attachView(V v);

    void detachView();
}
