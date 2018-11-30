package com.geelaro.ban.ui.view;

import com.geelaro.ban.bean.top250.Root;
import com.geelaro.ban.ui.base.IBaseView;

/**
 * Created by LEE on 2018/3/8.
 */

public interface ITop250View extends IBaseView{
    void getTop250Success(Root root,boolean isLoadMore);
    void getDataFailure();
}
