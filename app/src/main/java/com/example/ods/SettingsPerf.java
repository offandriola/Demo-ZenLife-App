package com.example.ods;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SettingsPerf extends AppCompatActivity {

    private TextView edtNome1;
    private TextView edtDataNascimento;
    private TextView edtCpf;
    private TextView edtEmail;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings_perf);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView edtNome1 = findViewById(R.id.edtNome1);
        TextView edtDataNascimento = findViewById(R.id.edtDataNascimento);
        TextView edtCpf = findViewById(R.id.edtCpf);
        TextView edtEmail = findViewById(R.id.edtEmail);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        edtNome1.setText("Caio Castro");
        edtDataNascimento.setText("01/05/1989");
        edtCpf.setText("123.543.234-32");
        edtEmail.setText("caio@gmail.com");

        btnVoltar.setOnClickListener(v -> {
            // Lógica para voltar à tela de login
            finish(); // Apenas finaliza a atividade atual
        });

    }

}