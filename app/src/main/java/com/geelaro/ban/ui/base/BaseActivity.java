package com.geelaro.ban.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by LEE on 2018/2/7.
 */

public abstract class BaseActivity<V,T extends BasePresenter> extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(createResId());


    }



    public abstract int createResId();
}
