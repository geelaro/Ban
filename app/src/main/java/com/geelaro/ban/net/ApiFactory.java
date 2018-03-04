package com.geelaro.ban.net;

/**
 * Created by LEE on 2018/2/7.
 */

public class ApiFactory {

     static DoubanApi doubanApiSingleton;
     protected static Object monitor = new Object();

     public static DoubanApi getDoubanApiSingleton(){
         synchronized (monitor){
             if (doubanApiSingleton==null){
                 doubanApiSingleton = new RetrofitApi().getDoubanApi();
             }
             return doubanApiSingleton;
         }
     }
}
