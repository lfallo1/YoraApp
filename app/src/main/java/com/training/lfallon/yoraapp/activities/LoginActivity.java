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
    private static final int REQUEST_EXTERNAL_LOGIN = 2;
    private static final int REQUEST_REGISTER = 3;

    private View loginButton;
    private View registerButton;
    private View facebookButton;
    private View googleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //setup buttons
        loginButton = findViewById(R.id.activity_login_login);
        if(loginButton != null){
            loginButton.setOnClickListener(this);
        }

        registerButton = findViewById(R.id.activity_login_register);
        facebookButton = findViewById(R.id.activity_login_facebook);
        googleButton = findViewById(R.id.activity_login_google);

        registerButton.setOnClickListener(this);
        facebookButton.setOnClickListener(this);
        googleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == loginButton) {
            startActivityForResult(new Intent(this, LoginNarrowActivity.class), REQUEST_NARROW_LOGIN);
        }
        else if (view == registerButton){
            startActivityForResult(new Intent(this, RegisterActivity.class), REQUEST_REGISTER);
        }
        else if (view == facebookButton){
            Intent intent = new Intent(this, ExternalLoginActivity.class);
            intent.putExtra(ExternalLoginActivity.EXTRA_EXTERNAL_SERVICE, "Facebook");
            startActivityForResult(intent, REQUEST_EXTERNAL_LOGIN);
        }
        else if (view == googleButton) {
            Intent intent = new Intent(this, ExternalLoginActivity.class);
            intent.putExtra(ExternalLoginActivity.EXTRA_EXTERNAL_SERVICE, "Google");
            startActivityForResult(intent, REQUEST_EXTERNAL_LOGIN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode != RESULT_OK)
            return;

        if(requestCode == REQUEST_NARROW_LOGIN
                || requestCode == REQUEST_EXTERNAL_LOGIN
                || requestCode == REQUEST_REGISTER){
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
