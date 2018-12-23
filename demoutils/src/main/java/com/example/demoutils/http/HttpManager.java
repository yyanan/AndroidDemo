package com.example.demoutils.http;

import com.example.demoutils.app.MyApp;
import com.example.demoutils.utils.SystemUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager {
    public static HttpManager httpManager;

    public HttpManager() {
    }

    public static HttpManager getInstance() {
        if (httpManager == null) {
            synchronized (HttpManager.class) {
                if (httpManager == null) {
                    httpManager = new HttpManager();
                }
            }
        }
        return httpManager;
    }

    public Retrofit getRetrofit(String baseUrl) {
        return new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(getOkhttpClient()).build();
    }
    private OkHttpClient getOkhttpClient() {
        //缓存文件定义：缓存到当前项目的包路径下
        Cache cache = new Cache(new File(MyApp.getMyApp().getCacheDir(), "Cache"), 1024 * 1024 * 10);
        //网络请求的Log日志输出
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        //缓存拦截器
        MyCacheinterceptor myCacheinterceptor = new MyCacheinterceptor();
        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .cache(cache)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(myCacheinterceptor)
                .addNetworkInterceptor(myCacheinterceptor)
                //启用错误重连
                .retryOnConnectionFailure(true)
                .build();
    }
    private class MyCacheinterceptor implements Interceptor {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                //这里就是说判读我们的网络条件，要是有网络的话我么就直接获取网络上面的数据，要是没有网络的话我么就去缓存里面取数据
                if (!SystemUtil.isNetworkConnected()) {
                    request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();

                }
                Response originalResponse = chain.proceed(request);
                if (SystemUtil.isNetworkConnected()) {
                    int maxAge = 0;
                    return originalResponse.newBuilder()
                            // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .removeHeader("Pragma")
                            .header("Cache-Control", "public ,max-age=" + maxAge)
                            .build();
                } else {
                    int maxStale = 60 * 60 * 24 * 7;
                    return originalResponse.newBuilder()
                            // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .removeHeader("Pragma")
                            //这里的设置的是我们的没有网络的缓存时间，想设置多少就是多少。
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .build();
                }

            }
        }
        public <S> S getServer(String baseUrl, Class<S> tSClass) {
        return getRetrofit(baseUrl).create(tSClass);
    }
}
