package com.example.ods;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SettingsConf extends AppCompatActivity {

    private Switch swNotificacao;
    private Button btnVoltar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings_conf);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        swNotificacao = findViewById(R.id.swNotificacao);
        btnVoltar = findViewById(R.id.btnVoltar);

        swNotificacao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Mensagem ao ativar
                    Toast.makeText(getApplicationContext(), "Notificações ativadas", Toast.LENGTH_SHORT).show();
                } else {
                    // Mensagem ao desativar
                    Toast.makeText(getApplicationContext(), "Notificações desativadas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnVoltar.setOnClickListener(v -> {
            // Lógica para voltar à tela de login
            finish(); // Apenas finaliza a atividade atual
        });
    }
}