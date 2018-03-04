package com.geelaro.ban.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by LEE on 2018/2/14.
 */

public abstract class BaseFragment<V, T extends BasePresenter> extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(createViewId(), container, false);
        initView(rootView);
        return rootView;
    }

    protected abstract int createViewId();

    protected abstract void initView(View view);
}
