package com.geelaro.ban.ui.presenter;

import android.content.Context;
import android.widget.Toast;

import com.geelaro.ban.bean.top250.Root;
import com.geelaro.ban.net.DoubanApi;
import com.geelaro.ban.ui.base.BasePresenter;
import com.geelaro.ban.ui.view.ITop250View;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by LEE on 2018/3/8.
 */

public class MoviePresenter extends BasePresenter {

    public MoviePresenter(Context context) {
        super(context);
    }


    public void getMovieTop250(ITop250View top250View, int start, int count, boolean isLoadMore) {
        doubanApi.getMovieTop250(start, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(root -> {
                    disPlayTop250(top250View, root, isLoadMore);
                }, this::loadError);

    }

    private void disPlayTop250(ITop250View top250View, Root root, boolean isLoadMore) {
        top250View.getTop250Success(root, isLoadMore);
    }

    private void loadError(Throwable throwable) {
        throwable.printStackTrace();
        Toast.makeText(context, "网络不见了", Toast.LENGTH_SHORT).show();
    }

}
