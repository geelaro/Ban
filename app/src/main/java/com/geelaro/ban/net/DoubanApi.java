package com.geelaro.ban.net;

import com.geelaro.ban.bean.top250.Root;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by LEE on 2018/2/7.
 */

public interface DoubanApi {
    @GET("movie/in_theaters")
    Observable<Root> getMovieLive();

    @GET("movie/top250")
    Observable<Root> getMovieTop250(@Query("start") int start, @Query("count") int count);



}
