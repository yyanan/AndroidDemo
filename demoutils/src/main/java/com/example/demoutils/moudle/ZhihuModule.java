package com.example.demoutils.moudle;

import com.example.demoutils.base.moudle.HttpFinishCallback;
import com.example.demoutils.beans.zhihu.DailyListBean;
import com.example.demoutils.http.BaseObserver;
import com.example.demoutils.http.ZhuhuManager;
import com.example.demoutils.utils.RxUtils;

public class ZhihuModule {
    public interface ZHihuCallBack extends HttpFinishCallback{
        void setDailyListBean(DailyListBean data);
    }
    public void getDailyListBean(final ZHihuCallBack zHihuCallBack){
        zHihuCallBack.setShowProgressbar();
        ZhuhuManager.getZhuhuServer().getDailyList().compose(RxUtils.<DailyListBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<DailyListBean>(zHihuCallBack) {
            @Override
            public void onNext(DailyListBean value) {
                zHihuCallBack.setDailyListBean(value);
            }
        });
    }
}
