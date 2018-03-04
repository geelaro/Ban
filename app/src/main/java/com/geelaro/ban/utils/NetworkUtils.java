package com.geelaro.ban.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by geelaro on 2018/2/8.
 * 网络工具
 */

public class NetworkUtils {

    public static boolean isNetworkAvailable(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm==null){
            return false;
        }

        NetworkInfo networkInfo  = cm.getActiveNetworkInfo();
        if (networkInfo==null){
            return false;
        }
        return networkInfo.isAvailable();
    }
}
