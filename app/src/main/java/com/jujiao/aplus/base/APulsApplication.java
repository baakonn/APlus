package com.jujiao.aplus.base;


import android.app.Application;
import android.content.Context;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APulsApplication extends Application {
    public static final String SESSION_TOKEN_KEY = "aplus-Token";

    private static APulsApplication aPulsApplication;
    public static Context baseContext;

    public static APulsApplication getInstance() {
        return aPulsApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        baseContext = getApplicationContext();
        aPulsApplication = this;
        initOkHttpUtils();
    }

    /**
     * 初始OkHttpUtils
     * 图片加载框架Glide,使用OkHttp处理网络请求
     */
    private void initOkHttpUtils() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //log   tag:okhtt
                .addInterceptor(new LoggerInterceptor("okhttp"))
                // 统一添加的请求Header
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder()
                                .addHeader("Content-Type", "application/json")
                                .header("Content-Encoding", "gzip")//使用gzip压缩
//                                .addHeader(SESSION_TOKEN_KEY, UserInfoKeeper.getToken())//是否使用token
                                .build();
                        return chain.proceed(request);
                    }
                }).build();

        OkHttpUtils.initClient(okHttpClient);

        //gidle 是否使用okhttp
//        Glide.get(this).register(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(new com.squareup.okhttp.OkHttpClient()));
    }
}
