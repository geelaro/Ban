package com.geelaro.ban;

import android.app.Application;
import android.content.Context;

/**
 * Created by LEE on 2018/2/7.
 */

public class BanApp extends Application{
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
}
