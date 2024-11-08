package com.example.ods.service;


import android.util.Log;

import com.example.ods.domain.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.Optional;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static Retrofit retrofit;

    public RetrofitService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.15.8:8080/") // para emulador; ajuste conforme necessário
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }

//    private void listAllUsers() {
//        Call<List<User>> call = userService.getAllUsers();
//        call.enqueue(new Callback<List<User>>() {
//            @Override
//            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    System.out.println("Step 1");
//                    List<User> userList = response.body();
//                    System.out.println("Step 2");
//                    userAdapter = new UserAdapter(userList);
//                    System.out.println("Step 3");
//                    recyclerView.setAdapter(userAdapter);  // Certifique-se de que esta linha esteja aqui
//                    System.out.println("Step 4");
//                } else {
//                    Log.e("Error", "Erro ao listar usuários");
//                }
//            }
//
//
//            @Override
//            public void onFailure(Call<List<User>> call, Throwable t) {
//                Log.e("Error", "Falha na chamada: " + t.getMessage());
//            }
//        });
//    }
//
//    public ResponseEntity<?> buscaPorId(Long id) {
//        Optional<User> record = this.userRepository.findById(id);
//
//        if(record.orElseGet(() -> null) != null){
//            return new ResponseEntity<User>(record.get(),HttpStatus.OK);
//        }else{
//            return new ResponseEntity<String>("Usuario não localizado", HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    public void createUser(User user) {
//        Call<User> call = apiService.createUser(user);
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                if (response.isSuccessful()) {
//                    // Sucesso ao criar usuário
//                    User createdUser = response.body();
//                    System.out.println("Usuário criado com sucesso: " + createdUser.getName());
//                } else {
//                    // Erro na resposta
//                    System.out.println("Erro ao criar usuário: " + response.message());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                // Erro na chamada da API
//                System.out.println("Falha na criação do usuário: " + t.getMessage());
//            }
//        });
//    }


}

