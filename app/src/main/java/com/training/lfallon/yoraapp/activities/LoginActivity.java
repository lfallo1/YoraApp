package com.training.lfallon.yoraapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.training.lfallon.yoraapp.R;

/**
 * Login / Welcome screen Activity.
 * Contains buttons for logging in, signing up, signing with google, or signing in with facebook
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private static final String tag = LoginActivity.class.getSimpleName();

    private View loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //setup buttons
        loginButton = findViewById(R.id.activity_login_login);
        if(loginButton != null){
            loginButton.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if(v == loginButton){
            startActivity(new Intent(this, LoginNarrowActivity.class));
        }
    }
}
