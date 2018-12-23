package com.example.myapputils.app;

import android.app.Application;

public class MyApp extends Application {

    private static MyApp myapp;
    @Override
    public void onCreate() {
        super.onCreate();
        myapp=this;
    }
    public static MyApp getMyApp(){
        return myapp;
    }
}
