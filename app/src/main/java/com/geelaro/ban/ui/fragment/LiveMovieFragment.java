package com.geelaro.ban.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.geelaro.ban.R;
import com.geelaro.ban.ui.base.BaseFragment;
import com.geelaro.ban.ui.base.BasePresenter;
import com.geelaro.ban.ui.presenter.MoviePresenter;

/**
 * Created by LEE on 2018/6/6.
 */

public class LiveMovieFragment extends BaseFragment<MoviePresenter> {

    public static LiveMovieFragment newInstance() {

        Bundle args = new Bundle();
        LiveMovieFragment fragment = new LiveMovieFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int createViewId() {
        return R.layout.frame_book;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected MoviePresenter createPresenter() {
        return null;
    }


}
