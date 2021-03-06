package com.training.lfallon.yoraapp.infrastructure;

import android.app.Application;

/**
 * Application entry point (override Application name property in Android manifest
 */
public class YoraApplication extends Application {
    private Auth auth;

    @Override
    public void onCreate() {
        super.onCreate();
        auth = new Auth(this);
    }

    public Auth getAuth() {
        return auth;
    }
}
