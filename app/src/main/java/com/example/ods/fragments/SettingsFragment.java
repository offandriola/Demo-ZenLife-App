package com.example.ods.fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ods.MainActivity;
import com.example.ods.R;
import com.example.ods.SettingsConf;
import com.example.ods.SettingsExercise;
import com.example.ods.SettingsPerf;

public class SettingsFragment extends Fragment {

    private Button btnSair;
    private Button btnConfig;
//    private Button btnExerci;
    private Button btnPerfil;

    public SettingsFragment() {
        // Construtor público vazio necessário
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla o layout para este fragmento
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // Referência para o botão "Sair"
        btnSair = view.findViewById(R.id.btnSair);
        btnConfig = view.findViewById(R.id.btnConfig);
//        btnExerci = view.findViewById(R.id.btnExerci);
        btnPerfil = view.findViewById(R.id.btnPerfil);

        // Configuração do clique do botão "Sair"
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Encerra a atividade que contém o fragmento
                if (getActivity() != null) {
                    getActivity().finish();
                }
            }
        });

        // Configuracao do clique do botao configuracoes
        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Encerra a atividade que contém o fragmento
                if (getActivity() != null) {
                    Intent settings = new Intent(getActivity(), SettingsConf.class);
                    startActivity(settings);
                }
            }
        });

        // Configuracao do clique do botao perfil
        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Encerra a atividade que contém o fragmento
                if (getActivity() != null) {
                    Intent settings = new Intent(getActivity(), SettingsPerf.class);
                    startActivity(settings);
                }
            }
        });

        // Configuracao do clique do botao exercicios
//        btnExerci.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Encerra a atividade que contém o fragmento
//                if (getActivity() != null) {
//                    Intent settings = new Intent(getActivity(), SettingsExercise.class);
//                    startActivity(settings);
//                }
//            }
//        });

        return view; // Retorna a view inflada
    }
}
