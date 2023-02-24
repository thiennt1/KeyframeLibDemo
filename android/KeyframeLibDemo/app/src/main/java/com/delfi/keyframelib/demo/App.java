package com.delfi.keyframelib.demo;

import android.app.Application;

import com.delfi.keyframelib.KeyframeApp;

public class App extends Application {
    private static App instance;

    public static App getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        KeyframeApp.init(this);
    }
}
