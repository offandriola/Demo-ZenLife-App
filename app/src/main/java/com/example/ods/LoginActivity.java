package com.example.ods;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"; // Regex para validação de e-mail
    private static final String ERROR_EMPTY_EMAIL = "Preencha o E-mail!";
    private static final String ERROR_EMPTY_PASSWORD = "Preencha a Senha!";
    private static final String ERROR_INVALID_EMAIL = "E-mail inválido!";
    private static final String ERROR_INVALID_PASSWORD = "A senha precisa ter pelo menos 6 caracteres!";

    private EditText editEmail;
    private EditText editSenha;
    private Button btnEntrar;
    private Button btnSair;
    private ProgressBar progressBar;
    private TextView txtTelaCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Cor da barra
        getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));
        getWindow().setNavigationBarColor(Color.parseColor("#FFFFFF"));

        // ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Referências para os componentes
        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnSair = findViewById(R.id.btnSair);
        progressBar = findViewById(R.id.progressBar);
        txtTelaCadastro = findViewById(R.id.txtTelaCadastro);

        // On click botão "Entrar"
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(v); // Esconde o teclado

                String email = editEmail.getText().toString();
                String senha = editSenha.getText().toString();

                if (email.isEmpty()) {
                    editEmail.setError(ERROR_EMPTY_EMAIL);
                    editEmail.requestFocus();
                    return;
                }

                if (senha.isEmpty()) {
                    editSenha.setError(ERROR_EMPTY_PASSWORD);
                    editSenha.requestFocus();
                    return;
                }

                if (!Pattern.matches(EMAIL_PATTERN, email)) {
                    Snackbar snackbar = Snackbar.make(v, ERROR_INVALID_EMAIL, Snackbar.LENGTH_SHORT);
                    snackbar.show();
                    editEmail.requestFocus();
                    return;
                }

                if (senha.length() < 6) {
                    Snackbar snackbar = Snackbar.make(v, ERROR_INVALID_PASSWORD, Snackbar.LENGTH_SHORT);
                    snackbar.show();
                    editSenha.requestFocus();
                    return;
                }

                btnEntrar.setEnabled(false);
                login();
            }
        });

        // On click botão "Sair"
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // Método para esconder o teclado
    private void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    // On click TextView "Cadastre-se"
    public void cadastro(View view) {
        Intent it = new Intent(this, CadastroActivity.class);
        startActivity(it);
    }

    // Exibe a barra de progresso enquanto o login está sendo processado
    private void login() {
        progressBar.setVisibility(View.VISIBLE);

        // Cria um novo Handler para executar código no thread principal após um atraso
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // Esconde a barra de progresso após o atraso
                progressBar.setVisibility(View.GONE);
                btnEntrar.setEnabled(true);
                redirectToLogin();
                Snackbar snackbar = Snackbar.make(progressBar, "Login efetuado com sucesso!", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        }, 3000);
    }

    private void redirectToLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
