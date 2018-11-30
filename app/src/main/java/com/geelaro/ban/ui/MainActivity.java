package com.geelaro.ban.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.geelaro.ban.R;
import com.geelaro.ban.ui.base.BaseActivity;
import com.geelaro.ban.ui.fragment.BookFragment;
import com.geelaro.ban.ui.fragment.MovieFragment;
import com.geelaro.ban.ui.fragment.MusicFragment;
import com.geelaro.ban.ui.fragment.Top250FilmFragment;
import com.geelaro.ban.ui.presenter.MainPresenter;
import com.geelaro.ban.ui.view.IMainView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresenter> implements
        BottomNavigationView.OnNavigationItemSelectedListener, IMainView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.navigation)
    BottomNavigationView navigationView;
    private MainPresenter mainPresenter;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
//        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().getDecorView().setSystemUiVisibility(
//                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        } else if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
//
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }
        //

        ButterKnife.bind(this);
        mainPresenter = new MainPresenter(this, this);
        setSupportActionBar(toolbar);
        //
        fragmentManager = getSupportFragmentManager();
        navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);

        switch2Movie();//进入app显示Movie

    }

    @Override
    public int createResId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter createPresenter() {
        return null;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mainPresenter.NavigationItemSelected(item);
//        item.setChecked(true);
        return true;
    }

    @Override
    public void switch2Movie() {
        fragmentManager.beginTransaction()
                .replace(R.id.container, MovieFragment.newInstance())
                .commit();
    }

    @Override
    public void switch2Music() {
        fragmentManager.beginTransaction()
                .replace(R.id.container, new MusicFragment())
                .commit();
    }

    @Override
    public void switch2Book() {
        fragmentManager.beginTransaction()
                .replace(R.id.container, new BookFragment())
                .commit();
    }
}
