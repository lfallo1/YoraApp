package com.training.lfallon.yoraapp.activities;

import android.os.Bundle;
import android.util.Log;

import com.training.lfallon.yoraapp.R;

public class MainActivity extends BaseAuthenticatedActivity {

    private static final String tag = MainActivity.class.getSimpleName();

    @Override
    protected void onYoraCreate(Bundle savedState) {
        setContentView(R.layout.activity_main);
        Log.d(tag, "Logged in and MainActivity launched");
    }
}
