package com.example.finalapp;

import android.os.Bundle;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.finalapp.databinding.ActivityExplore2Binding;

public class Explore2 extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityExplore2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setSupportActionBar(MaterialCardView f) {
    }
}