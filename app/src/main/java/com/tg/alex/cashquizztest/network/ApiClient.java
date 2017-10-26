package com.tg.alex.cashquizztest.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.androidannotations.annotations.EBean;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alex on 10/26/2017.
 */

@EBean(scope = EBean.Scope.Singleton)
public class ApiClient {

    private final String BASE_URL = "https://gist.githubusercontent.com/donatienthorez/8bbd03c077a01f9bce620d1cfa79dfad/raw/";

    private Retrofit mRetrofit;
    private OkHttpClient client;

    public ApiClient() {
        // interceptor to log our requests to AndroidMonitor
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.addInterceptor(interceptor);
        clientBuilder.connectTimeout(30, TimeUnit.SECONDS);
        clientBuilder.readTimeout(60, TimeUnit.SECONDS);
        clientBuilder.build();

        client = clientBuilder.build();

        // JSON serialize-deserialize library
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        mRetrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    /**
     * Method to get the API Service built using this client.
     *
     * @return The API Service
     */
    public ApiInterface getService() {
        return mRetrofit.create(ApiInterface.class);
    }

}
