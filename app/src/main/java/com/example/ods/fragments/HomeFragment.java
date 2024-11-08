package com.example.ods.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ods.HistoricoMed;
import com.example.ods.LoginActivity;
import com.example.ods.R;

public class HomeFragment extends Fragment {
    private CardView cardView;

    public HomeFragment() {}

    @Override
    public View onCreateView
    (LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        cardView = view.findViewById(R.id.cardFormulario);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getActivity(), HistoricoMed.class);
                startActivity(intent);
            }
        });

        return view;
    }
}