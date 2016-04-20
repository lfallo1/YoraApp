package com.training.lfallon.yoraapp.infrastructure;

import android.content.Context;

public class Auth {
    private final Context context;
    private User user;

    public Auth(Context context) {
        this.context = context;
    }

    public User getUser() {
        return user;
    }
}
