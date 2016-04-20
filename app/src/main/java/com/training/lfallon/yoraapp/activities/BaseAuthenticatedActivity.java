package com.training.lfallon.yoraapp.activities;

import android.content.Intent;
import android.os.Bundle;

/**
 * Base activity for majority of activities that enforce authentication.
 * Enforces that user is logged in.
 * Will either (a) log user in with cached login information or (b) kick user out to login activity
 */
public abstract class BaseAuthenticatedActivity extends BaseActivity {

    /**
     * Declared final because sub-classes should never override this method.
     * Custom setup for individual activites should be implemented in onYoraCreate which is always called if the user is logged in
     * <br>
     * By using this strategy, we can avoid initializing activities that are killed / finished due to no auth
     * @param savedState
     */
    @Override
    protected final void onCreate(Bundle savedState){
        super.onCreate(savedState);

        //if not logged in, finish activity and create new LoginActivity
        if(!application.getAuth().getUser().isLoggedIn()){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        //if logged in, call the onYoraCreate to initialize the activity
        onYoraCreate(savedState);
    }

    /**
     * Method to be implemented in each activity extending from BaseAuthenticationActivity.
     * All logic that would generally go inside onCreate will be implemented here
     * @param savedState
     */
    protected abstract void onYoraCreate(Bundle savedState);
}
