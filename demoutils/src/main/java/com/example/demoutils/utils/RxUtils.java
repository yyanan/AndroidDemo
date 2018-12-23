package com.example.demoutils.utils;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 项目名：MyProject
 * 包名：  com.liangxq.mydemo.utils
 * 文件名：RxUtils
 * 创建者：liangxq
 * 创建时间：2018/12/21  9:46
 * 描述：TODO
 */
public class RxUtils {


    public static <T> ObservableTransformer<T, T> rxObserableSchedulerHelper() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
