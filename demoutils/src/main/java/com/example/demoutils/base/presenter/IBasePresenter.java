package com.example.demoutils.base.presenter;

import java.lang.ref.WeakReference;

public class IBasePresenter<V> implements BasePresenter<V> {
    private WeakReference<V> weakReference;
    public V mView;
    @Override
    public void attachView(V v) {
        weakReference=new WeakReference<V>(v);
        mView=weakReference.get();
    }

    @Override
    public void detachView() {
        if (weakReference != null&&weakReference.get()!=null) {
            weakReference.clear();
            weakReference=null;
        }
    }
}
