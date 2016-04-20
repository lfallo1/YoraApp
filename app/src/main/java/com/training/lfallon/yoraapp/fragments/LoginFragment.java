package com.training.lfallon.yoraapp.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.training.lfallon.yoraapp.R;

/**
 * LoginFragment - handle events related to the Login Fragment
 */
public class LoginFragment extends BaseFragment implements View.OnClickListener {

    private View loginButton;
    private LoginCallbacks callbacks;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        loginButton = view.findViewById(R.id.fragment_login_loginButton);
        loginButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v == loginButton){
            //TODO check username and password

            // notify parent activity
            application.getAuth().getUser().setIsLoggedIn(true);
            callbacks.onLoggedIn();
        }
    }

    /**
     * API 23 and lower
     * @param activity
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        callbacks = (LoginCallbacks)activity;
    }

    /**
     * API 23 and later
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callbacks = (LoginCallbacks)context;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        //prevent fragment from outliving activity it is attached to.
        callbacks = null;
    }

    /**
     * LoginCallbacks interface
     * should be implemented by any activities that LoginFragment is attached to
     */
    public interface LoginCallbacks {
        void onLoggedIn();
    }
}
