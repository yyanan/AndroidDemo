package com.example.demoutils.http;

import com.example.demoutils.beans.zhihu.DailyListBean;

import io.reactivex.Observable;

public class ZhuhuManager {
    private static ZhuhuServer zhuhuServer;
    public static ZhuhuServer getZhuhuServer(){
        if (zhuhuServer==null){
            synchronized (ZhuhuServer.class){
                if (zhuhuServer == null) {
                    zhuhuServer=HttpManager.getInstance().getServer(ZhuhuServer.HOST,ZhuhuServer.class);
                }
            }
        }
        return zhuhuServer;
    }
    public Observable<DailyListBean> getDailyList(){
        return zhuhuServer.getDailyList();
    }
}
