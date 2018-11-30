package com.geelaro.ban.utils;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.geelaro.ban.R;

/**
 * Created by LEE on 2018/6/6.
 */

public class DisplayImgUtil {

    /**
     * 利用开源库Glide加载图片
     */
    public static void display(Context context, String url, ImageView imageView) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context)
                .load(url)
                .crossFade()
                .placeholder(R.drawable.ic_image_loading)
                .error(R.drawable.ic_image_loadfail)
                .into(imageView);
    }
}
