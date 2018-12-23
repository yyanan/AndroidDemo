package com.example.demoutils.http;

import android.content.ComponentCallbacks;

import com.example.demoutils.base.moudle.HttpFinishCallback;

import java.util.Observable;
import java.util.logging.Logger;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public abstract class BaseObserver<T> implements Observer<T> {

    private HttpFinishCallback httpFinishCallback;
    public BaseObserver(HttpFinishCallback httpFinishCallback){
        this.httpFinishCallback=httpFinishCallback;
    }
    private CompositeDisposable compositeDisposable=new CompositeDisposable();

    @Override
    public void onSubscribe(Disposable d) {
        compositeDisposable.add(d);
    }

    @Override
    public void onError(Throwable e) {
        if (compositeDisposable!=null) {
            compositeDisposable.clear();
        }
        if (httpFinishCallback != null) {
            if (e instanceof HttpException) {
                httpFinishCallback.setError("网络请求失败");
            }else {
                httpFinishCallback.setError("其他请求错误");
            }
            Logger.getLogger(e.getMessage());
            httpFinishCallback.setHideProgressbar();
        }
    }

    @Override
    public void onComplete() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
        if (httpFinishCallback != null) {
            httpFinishCallback.setHideProgressbar();
        }
    }
}
