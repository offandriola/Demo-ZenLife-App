package com.example.ods.service;

import com.example.ods.domain.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @GET("users/all")
    Call<List<User>> getAll();

    @POST("users/add")
    Call<User> addNewUser(@Body User user);

    @GET("users/user/{id}")
    Call<User> getById(@Path("id") Integer id);

    @GET("users/user/{id}/treinos")
    Call<List<User>> getAllTreinosByUserId();

    @POST("users/add/{id}/treinos")
    Call<User> addNewTreinoByUserId(@Body User user);

    @GET("users/user/{id}/historico")
    Call<User> getHistorioTreinosByUserId(@Path("id") Integer id);

}
