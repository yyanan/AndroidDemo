package com.example.myapputils.http;


import com.example.myapputils.base.module.HttpFinishCallback;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public abstract class BaseObserver<T> implements Observer<T> {

    //回调结果处理
    private HttpFinishCallback httpFinishCallback;

    public BaseObserver(HttpFinishCallback httpFinishCallback) {
        this.httpFinishCallback = httpFinishCallback;
    }

    //管理内存网络请求
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void onSubscribe(Disposable d) {
        compositeDisposable.add(d);
    }

    @Override
    public void onError(Throwable e) {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
        if (httpFinishCallback != null) {
            if (e instanceof HttpException) {
                httpFinishCallback.setError("网络请求错误");
            }
        }
    }

    @Override
    public void onComplete() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }
}
