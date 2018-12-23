package com.example.myapputils.http;

import com.example.myapputils.beans.zhihu.DailyListBean;

import io.reactivex.Observable;

public class ZhihuManager {

    private static MyServer myServer;

    public static MyServer getMyServer(){
        if (myServer == null) {
            synchronized (MyServer.class){
                if (myServer == null) {
                    myServer=HttpManager.getInstance().getServer(MyServer.HOST,MyServer.class);

                }
            }
        }
        return myServer;
    }
    public Observable<DailyListBean> getDailyList(){
        return myServer.getDailyList();
    }
}
