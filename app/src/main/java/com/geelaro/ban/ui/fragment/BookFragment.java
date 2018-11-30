package com.geelaro.ban.ui.fragment;

import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.geelaro.ban.R;
import com.geelaro.ban.ui.base.BaseFragment;
import com.geelaro.ban.ui.base.BasePresenter;


/**
 * Created by LEE on 2018/2/7.
 */

public class BookFragment extends BaseFragment {

    private TextView text;


    @Override
    protected int createViewId() {
        return R.layout.frame_book;
    }

    @Override
    protected void initView(View view) {
        Button button = view.findViewById(R.id.button_record);
        text = view.findViewById(R.id.textView2);



//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getActivity(), AudioRecord.class));
//            }
//        });

    }

    @Override
    public void onResume() {
        super.onResume();
        String date = (String) DateUtils.getRelativeTimeSpanString(System.currentTimeMillis());
        text.setText(date);

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }





}
