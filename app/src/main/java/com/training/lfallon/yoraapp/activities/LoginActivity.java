package com.training.lfallon.yoraapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.training.lfallon.yoraapp.R;

public class LoginActivity extends BaseActivity {

    private static final String tag = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
    }

    public void doLogin(View view) {
        application.getAuth().getUser().setIsLoggedIn(true);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
