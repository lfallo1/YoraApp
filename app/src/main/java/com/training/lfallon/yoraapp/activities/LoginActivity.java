package com.training.lfallon.yoraapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.training.lfallon.yoraapp.R;
import com.training.lfallon.yoraapp.fragments.LoginFragment;

/**
 * Login / Welcome screen Activity.
 * Contains buttons for logging in, signing up, signing with google, or signing in with facebook
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginFragment.LoginCallbacks {

    private static final String tag = LoginActivity.class.getSimpleName();
    private static final int REQUEST_NARROW_LOGIN = 1;

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
            startActivityForResult(new Intent(this, LoginNarrowActivity.class), REQUEST_NARROW_LOGIN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode != RESULT_OK)
            return;

        if(requestCode == REQUEST_NARROW_LOGIN){
            finishLogin();
        }
    }

    //finish login --- more code / logic in future. but this will be reused code, regardless of how they are logging in
    private void finishLogin() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    /**
     * implement onLoggedIn since class implements LoginCallbacks interface
     */
    @Override
    public void onLoggedIn() {
        finishLogin();
    }
}
