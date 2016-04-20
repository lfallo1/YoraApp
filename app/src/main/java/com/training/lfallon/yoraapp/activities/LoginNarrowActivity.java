package com.training.lfallon.yoraapp.activities;

import android.os.Bundle;

import com.training.lfallon.yoraapp.R;
import com.training.lfallon.yoraapp.fragments.LoginFragment;

public class LoginNarrowActivity extends BaseActivity implements LoginFragment.LoginCallbacks {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_narrow);
    }

    @Override
    public void onLoggedIn() {
        setResult(RESULT_OK);
        finish();
    }
}
