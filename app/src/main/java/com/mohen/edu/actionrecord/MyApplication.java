package com.mohen.edu.actionrecord;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Kenneth on 2017/10/11.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
