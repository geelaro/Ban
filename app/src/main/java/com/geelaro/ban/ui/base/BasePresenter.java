package com.geelaro.ban.ui.base;

import android.content.Context;

import com.geelaro.ban.net.ApiFactory;
import com.geelaro.ban.net.DoubanApi;

/**
 * Created by LEE on 2018/2/7.
 */

public class BasePresenter {

    public DoubanApi doubanApi = ApiFactory.getDoubanApiSingleton();
    public Context context;

    public BasePresenter(Context context){
        this.context = context;
    }
}
