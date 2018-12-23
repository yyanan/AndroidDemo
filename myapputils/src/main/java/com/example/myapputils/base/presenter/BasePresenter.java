package com.example.myapputils.base.presenter;

public interface BasePresenter<V> {
    //绑定 View()
    void attachView(V v);

    //解绑 view()
    void detachView();
}
