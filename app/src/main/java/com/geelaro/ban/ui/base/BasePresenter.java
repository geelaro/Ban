package com.geelaro.ban.ui.base;

import com.geelaro.ban.net.ApiFactory;
import com.geelaro.ban.net.DoubanApi;

/**
 * Created by LEE on 2018/2/7.
 */

public class BasePresenter<V> {

    public DoubanApi doubanApi = ApiFactory.getDoubanApiSingleton();
}
