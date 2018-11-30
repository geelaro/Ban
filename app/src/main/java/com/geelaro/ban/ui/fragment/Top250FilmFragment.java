package com.geelaro.ban.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.geelaro.ban.R;
import com.geelaro.ban.bean.top250.Root;
import com.geelaro.ban.ui.adapter.Top250FilmAdapter;
import com.geelaro.ban.ui.base.BaseFragment;
import com.geelaro.ban.ui.presenter.MoviePresenter;
import com.geelaro.ban.ui.view.ITop250View;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LEE on 2018/3/8.
 */

public class Top250FilmFragment extends BaseFragment<MoviePresenter> implements ITop250View {
    private MoviePresenter moviePresenter;
    private LinearLayoutManager mLayoutManager;
    private Root mRoot;
    private Top250FilmAdapter mAdapter;

    @BindView(R.id.top250_recycleView)
    RecyclerView recyclerView;
//    @BindView(R.id.top250_refresh)
//    SwipeRefreshLayout mRefreshLayout;

    public static Top250FilmFragment newInstance() {

        Bundle args = new Bundle();
        Top250FilmFragment fragment = new Top250FilmFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int createViewId() {
        return R.layout.frame_top250;
    }

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this, view);
        moviePresenter = new MoviePresenter(getActivity());
        mLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        moviePresenter.getMovieTop250(this, 0, 20, false);

    }

    @Override
    protected MoviePresenter createPresenter() {
        return moviePresenter;
    }


    @Override
    public void getTop250Success(Root root, boolean isLoadMore) {
        if (isLoadMore) {
            mRoot.getSubjects().addAll(root.getSubjects());
            mAdapter.notifyDataSetChanged();
        } else {
            mRoot = root;
            mAdapter = new Top250FilmAdapter(getActivity(), mRoot);
            recyclerView.setAdapter(mAdapter);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void getDataFailure() {

    }


}
