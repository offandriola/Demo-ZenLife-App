package com.example.ods;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.ods.domain.User;
import com.example.ods.fragments.ExerciseFragment;
import com.example.ods.fragments.HistoryFragment;
import com.example.ods.fragments.HomeFragment;
import com.example.ods.fragments.SettingsFragment;
import com.example.ods.service.ApiService;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Map<Integer, Fragment> fragmentMap;
    private ApiService userService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // cor barra de status
        getWindow().setStatusBarColor(Color.parseColor("#1A1E29"));
        getWindow().setNavigationBarColor(Color.parseColor("#FFFFFF"));

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        fragmentMap = new HashMap<>();
        fragmentMap.put(R.id.nav_home, new HomeFragment());
        fragmentMap.put(R.id.nav_history, new HistoryFragment());
        fragmentMap.put(R.id.nav_exercise, new ExerciseFragment());
        fragmentMap.put(R.id.nav_settings, new SettingsFragment());

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, Objects.requireNonNull(fragmentMap.get(R.id.nav_home))).commit();
        }

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = fragmentMap.get(item.getItemId());

                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, selectedFragment).commit();
                }
                return true;
            }
        });

        // Configuração do Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.15.8:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userService = retrofit.create(ApiService.class);

        // Chamar o método para listar os usuários
        System.out.println("Vamos ver se dou certo");

        listAllUsers();
    }

    private void listAllUsers() {
        Call<List<User>> call = userService.getAll();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<User> userList = response.body();
                    for (User user : userList) {
                        System.out.println("ID: " + user.getId() + ", Name: " + user.getName());
                        Log.d("User", "ID: " + user.getId() + ", Name: " + user.getName());
                    }
                } else {
                    Log.e("Error", "Erro ao listar usuários");
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("Error", "Falha na chamada: " + t.getMessage());
            }
        });
    }

}