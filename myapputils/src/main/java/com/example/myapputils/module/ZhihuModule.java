package com.example.myapputils.module;

import com.example.myapputils.base.module.HttpFinishCallback;
import com.example.myapputils.beans.zhihu.DailyListBean;
import com.example.myapputils.http.BaseObserver;
import com.example.myapputils.http.ZhihuManager;
import com.example.myapputils.utils.RxUtils;

public class ZhihuModule {
    public interface ZHihuCallback extends HttpFinishCallback{
        void setDailyListBean(DailyListBean data);
    }
    public void getDailyListBean(final ZHihuCallback zHihuCallback){
        zHihuCallback.setShowProgressbar();
        ZhihuManager.getMyServer().getDailyList().compose(RxUtils.<DailyListBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<DailyListBean>(zHihuCallback) {
            @Override
            public void onNext(DailyListBean value) {
                zHihuCallback.setDailyListBean(value);
            }
        });
    }
}
