package com.example.ods.repository;

import com.example.ods.domain.User;
import com.example.ods.service.ApiService;
import com.example.ods.service.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Body;

public class UserRepository {
    private ApiService apiService;

    public UserRepository(){
        Retrofit retrofit = RetrofitService.getRetrofit();
        apiService = retrofit.create(ApiService.class);
    }

    public Call<List<User>> getAllUsers(){
        return apiService.getAll();
    }

    public Call<User> addNewUser(@Body User user){
        return apiService.addNewUser(user);
    }

    public Call<User> getUserById(Integer id){
        return apiService.getById(id);
    }
}
