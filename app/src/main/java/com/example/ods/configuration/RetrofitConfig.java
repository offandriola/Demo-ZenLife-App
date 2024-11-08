package com.example.ods.configuration;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private final Retrofit retrofit;

    public RetrofitConfig(){
        this.retrofit = new Retrofit.Builder().baseUrl("http://192.168.15.8:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
