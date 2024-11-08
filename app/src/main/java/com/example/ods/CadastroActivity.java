package com.example.ods;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CadastroActivity extends AppCompatActivity {

    private Button btnVoltar, btnCadastrarConta;
    private EditText editNome, editDataNascimento, editCpf, editEmail, editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Cor da barra
        getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));
        getWindow().setNavigationBarColor(Color.parseColor("#FFFFFF"));

        // Referências para os componentes
        btnCadastrarConta = findViewById(R.id.btnCadastrarConta);
        btnVoltar = findViewById(R.id.btnVoltar);
        editNome = findViewById(R.id.editNome);
        editDataNascimento = findViewById(R.id.editDataNascimento);
        editCpf = findViewById(R.id.editCpf);
        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);

        // Configuração dos botões
        btnCadastrarConta.setOnClickListener(v -> {
            // Obter os valores dos inputs
            String nome = editNome.getText().toString().trim();
            String dataNascimento = editDataNascimento.getText().toString().trim();
            String cpf = editCpf.getText().toString().trim();
            String email = editEmail.getText().toString().trim();
            String senha = editSenha.getText().toString().trim();

            // Validação do Nome
            if (!nome.matches("[a-zA-Z\\s]+")) {
                editNome.setError("O nome deve conter apenas letras.");
                return;
            } else {
                editNome.setError(null); // Limpa a mensagem de erro se o nome for válido
            }

            // Validação da Data de Nascimento
            if (!dataNascimento.matches("\\d{2}/\\d{2}/\\d{4}")) {
                editDataNascimento.setError("Data deve ser no formato dd/MM/yyyy");
                return;
            } else {
                editDataNascimento.setError(null); // Limpa a mensagem de erro se a data for válida
            }

            // Validação do CPF
            if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
                editCpf.setError("CPF deve estar no formato XXX.XXX.XXX-XX");
                return;
            } else {
                editCpf.setError(null); // Limpa a mensagem de erro se o CPF for válido
            }

            // Validação do E-mail
            if (!email.matches("[a-zA-Z0-9._%+-]+@(gmail\\.com|outlook\\.com|hotmail\\.com)")) {
                editEmail.setError("E-mail inválido. Use um dos domínios válidos.");
                return;
            } else {
                editEmail.setError(null); // Limpa a mensagem de erro se o e-mail for válido
            }

            // Validação da Senha
            if (senha.length() < 6) {
                editSenha.setError("A senha precisa ter no mínimo 6 caracteres");
                return;
            } else {
                editSenha.setError(null); // Limpa a mensagem de erro se a senha for válida
            }

//         Implementar lógica de verificação de CPF e E-mail no banco de dados
//         Se não houver cadastro, mostre uma mensagem de sucesso, Caso contrário, mostre uma mensagem de erro
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
        });

        btnVoltar.setOnClickListener(v -> {
            // Lógica para voltar à tela de login
            finish(); // Apenas finaliza a atividade atual
        });
    }
}