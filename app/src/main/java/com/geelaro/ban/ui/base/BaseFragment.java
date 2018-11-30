package com.geelaro.ban.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by LEE on 2018/2/14.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements IBaseView{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(createViewId(), container, false);
        initView(rootView);
        return rootView;
    }

    protected abstract int createViewId();

    protected abstract void initView(View view);

    protected abstract T createPresenter();

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showErrorMsg() {

    }
}
