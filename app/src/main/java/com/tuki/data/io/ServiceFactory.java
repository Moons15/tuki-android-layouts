package com.tuki.data.io;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {

    private final long CONNECT_TIMEOUT;
    private final long READ_TIMEOUT;
    private final HttpUrl BASE_URL;

    public ServiceFactory(long connectTime, String baseUrl) {
        CONNECT_TIMEOUT = connectTime;
        READ_TIMEOUT = connectTime;
        BASE_URL = HttpUrl.get(URI.create(baseUrl));
    }

    public TukiService makeTukiService(boolean isDebug) {
        OkHttpClient okHttpClient = makeOkHttpClient(makeDefaultInterceptor(isDebug));
        Retrofit retrofit = makeRetrofit(okHttpClient);
        return retrofit.create(TukiService.class);
    }

    private Retrofit makeRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private OkHttpClient makeOkHttpClient(Interceptor customInterceptor) {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(customInterceptor)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    private Interceptor makeDefaultInterceptor(boolean isDebug) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(isDebug ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        return logging;
    }
}
