package com.training.lfallon.yoraapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.training.lfallon.yoraapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.activity_register_username) EditText username;
    @Bind(R.id.activity_register_email) EditText email;
    @Bind(R.id.activity_register_password) EditText password;
    @Bind(R.id.activity_register_registerButton) View registerButton;
    @Bind(R.id.activity_register_progressBar) ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        registerButton.setOnClickListener(this);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        if(view == registerButton){
            application.getAuth().getUser().setIsLoggedIn(true);
            setResult(RESULT_OK);
            finish();
        }
    }
}
