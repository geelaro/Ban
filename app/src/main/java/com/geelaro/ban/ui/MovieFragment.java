package com.geelaro.ban.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geelaro.ban.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LEE on 2018/2/6.
 */

public class MovieFragment extends Fragment {

    public static MovieFragment newInstance(){
        MovieFragment bfm = new MovieFragment();
        Bundle args = new Bundle();
        bfm.setArguments(args);
        return bfm;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.frame_movie,container,false);
       return view;
    }

    private void setAdapter(ViewPager viewPager) {
        MovieAdapter adapter = new MovieAdapter(getChildFragmentManager(), getActivity());
        adapter.addFragment(MovieFragment.newInstance(), "影视");
        adapter.addFragment(MovieFragment.newInstance(), "音乐");
        adapter.addFragment(MovieFragment.newInstance(), "书籍");
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
