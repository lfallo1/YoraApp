package com.training.lfallon.yoraapp.activities;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.training.lfallon.yoraapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ExternalLoginActivity extends BaseActivity implements View.OnClickListener {

    public static final String EXTRA_EXTERNAL_SERVICE = "EXTRA_EXTERNAL_SERVICE";

    @Bind(R.id.activity_external_login_testButton) Button testButton;
    @Bind(R.id.activity_external_login_webView) WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_login);
        ButterKnife.bind(this);

        testButton.setOnClickListener(this);
        testButton.setText("Login with " + getIntent().getStringExtra(EXTRA_EXTERNAL_SERVICE));
    }

    @Override
    public void onClick(View view) {
        if(view == testButton){
            application.getAuth().getUser().setIsLoggedIn(true);
            setResult(RESULT_OK);
            finish();
        }
    }
}
