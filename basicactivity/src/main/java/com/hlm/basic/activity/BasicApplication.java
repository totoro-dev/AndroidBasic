package com.hlm.basic.activity;

import android.app.Application;
import android.content.Context;

public class BasicApplication extends Application {
    private static Context mContext;

    public BasicApplication() {
        mContext = this;
    }

    public static Context getApplication() {
        if (mContext == null) throw new RuntimeException("Application is null!");
        return mContext;
    }
}
