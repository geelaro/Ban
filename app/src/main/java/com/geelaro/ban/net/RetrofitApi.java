package com.geelaro.ban.net;

import com.geelaro.ban.BanApp;
import com.geelaro.ban.utils.NetworkUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LEE on 2018/2/7.
 */

public class RetrofitApi {

    private DoubanApi doubanApi;
    private static final String BASE_URL = "http://api.douban.com/v2/";

    public DoubanApi getDoubanApi() {
        return doubanApi;
    }

    RetrofitApi() {
        File cacheFile = new File(BanApp.getContext().getCacheDir(), "response");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 30);//30M

        OkHttpClient client = new OkHttpClient.Builder()
                .cache(cache)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        doubanApi = retrofit.create(DoubanApi.class);
    }


    private static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {

            CacheControl cacheControl = new CacheControl.Builder()
                    .maxAge(0, TimeUnit.SECONDS)
                    .maxStale(30, TimeUnit.DAYS)
                    .build();

            Request request = chain.request();
            if (!NetworkUtils.isNetworkAvailable(BanApp.getContext())) {
                request = request.newBuilder()
                        .cacheControl(cacheControl)
                        .build();
            }
            Response response = chain.proceed(request);

            if (NetworkUtils.isNetworkAvailable(BanApp.getContext())) {
                int maxAge = 0;
                return response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public ,max-age=" + maxAge)
                        .build();
            } else {
                int maxState = 60 * 60 * 24 * 7;
                return response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public ,only-if-cache ,max-stale=" + maxState)
                        .build();
            }
        }
    };


}
