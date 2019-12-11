package com.smnadim21.food1.advert.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://bdapps.b-rain.com.au/";
    private static final String FACTORY_URL = "https://app-factory.datasysbd.net/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getFactoryInstance() {
        return new Retrofit.Builder()
                .baseUrl(FACTORY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static String getBaseurl()
    {
        return BASE_URL;
    }
}