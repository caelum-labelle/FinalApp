package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.finalapp.databinding.ActivityMainBinding;

public class HomePage extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.home;
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.explore;
                    replaceFragment(new ExploreFragment());
                    break;
                case R.id.social;
                    replaceFragment(new SocialFragment());
                    break;
                case R.id.portfolio;
                    replaceFragment(new PortfolioFragment());
                    break;
                case R.id.profile;
                    replaceFragment(new ProfileFragment());
                    break;
            }
            return true;
        });
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();

    }
}