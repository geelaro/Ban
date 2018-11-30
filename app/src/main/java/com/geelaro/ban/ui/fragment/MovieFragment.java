package com.geelaro.ban.ui.fragment;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.TabLayout;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.geelaro.ban.R;
import com.geelaro.ban.ui.base.BaseFragment;
import com.geelaro.ban.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LEE on 2018/2/6.
 */

public class MovieFragment extends BaseFragment {

    TabLayout mTabLayout;
    ViewPager mViewPager;


    public static MovieFragment newInstance(){
        MovieFragment bfm = new MovieFragment();
        Bundle args = new Bundle();
        bfm.setArguments(args);
        return bfm;
    }


    @Override
    protected int createViewId() {
        return R.layout.frame_movie;
    }

    @Override
    protected void initView(View view) {
        mTabLayout = view.findViewById(R.id.tab_layout);
        mViewPager = view.findViewById(R.id.viewpager);
        mViewPager.setOffscreenPageLimit(3);
        setAdapter(mViewPager);

        mTabLayout.setupWithViewPager(mViewPager);

        new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                0);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    private void setAdapter(ViewPager viewPager) {
        MovieAdapter adapter = new MovieAdapter(getChildFragmentManager(), getActivity());
        adapter.addFragment(Top250FilmFragment.newInstance(), "Top250");
        adapter.addFragment(LiveMovieFragment.newInstance(), "热映榜");
//        adapter.addFragment(MovieFragment.newInstance(), "即将上映");
//        adapter.addFragment(MovieFragment.newInstance(), "我");
        viewPager.setAdapter(adapter);
    }

    class MovieAdapter extends FragmentPagerAdapter {
        private List<Fragment> fmList = new ArrayList<>();
        private List<String> fmTitles = new ArrayList<>();
        private Context mContext;

        public MovieAdapter(FragmentManager fm, Context context) {
            super(fm);
            mContext = context;
        }

        public void addFragment(Fragment fm, String title) {
            fmList.add(fm);
            fmTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return fmList.get(position);
        }

        @Override
        public int getCount() {
            return fmList != null ? fmList.size() : 0;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fmTitles.get(position);
        }

    }

}
