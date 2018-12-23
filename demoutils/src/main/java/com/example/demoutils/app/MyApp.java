package com.example.demoutils.app;

import android.app.Application;

public class MyApp extends Application {
    public static MyApp myApp;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp=this;
    }
    public static MyApp getMyApp(){
        return myApp;
    }
}
