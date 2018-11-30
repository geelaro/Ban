package com.geelaro.ban.ui.presenter;

import android.content.Context;
import android.view.MenuItem;

import com.geelaro.ban.R;
import com.geelaro.ban.ui.base.BasePresenter;
import com.geelaro.ban.ui.view.IMainView;


/**
 * Created by LEE on 2018/2/7.
 */

public class MainPresenter extends BasePresenter {

    private IMainView mainView;

    public MainPresenter(Context context,IMainView mainView){
        super(context);
        this.mainView = mainView;
    }

    public void NavigationItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.nav_movie:
                mainView.switch2Movie();
                break;
            case R.id.nav_music:
                mainView.switch2Music();
                break;
            case R.id.nav_book:
                mainView.switch2Book();
                break;
        }

    }
}
