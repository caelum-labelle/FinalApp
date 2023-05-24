package com.example.finalapp;

import static android.app.PendingIntent.getActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.finalapp.databinding.ActivityExplore2Binding;

public class Explore2 extends AppCompatActivity {

    private MaterialCardView f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore2);

        f = view.findViewById(R.id.f);

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Explore3.class);
                startActivity(intent);
            }
        });


        return view;
    }


}