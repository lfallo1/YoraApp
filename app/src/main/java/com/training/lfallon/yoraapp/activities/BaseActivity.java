package com.training.lfallon.yoraapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.training.lfallon.yoraapp.infrastructure.YoraApplication;

public abstract class BaseActivity extends AppCompatActivity {
    protected YoraApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (YoraApplication) getApplication();
    }
}