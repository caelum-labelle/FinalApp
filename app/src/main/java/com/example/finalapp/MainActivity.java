package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalapp.Adapter.CryptoWalletAdapter;
import com.example.finalapp.Domain.CryptoWallet;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON);

        ImageView logo = findViewById(R.id.logo);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade);
        logo.startAnimation(animation);

        recyclerViewWallet();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), LoginSignup.class));
            }
        }, 2000);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void recyclerViewWallet() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView = findViewById(R.id.viewactivities);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<CryptoWallet> cryptoWalletArrayList = new ArrayList<>();
        ArrayList<Integer> lineData = new ArrayList<>();
        lineData.add(1000);
        lineData.add(1100);
        lineData.add(1200);
        lineData.add(1300);

        ArrayList<Integer> lineData2 = new ArrayList<>();
        lineData2.add(2100);
        lineData2.add(1200);
        lineData2.add(2000);
        lineData2.add(1900);

        ArrayList<Integer> lineData3 = new ArrayList<>();
        lineData3.add(900);
        lineData3.add(1200);
        lineData3.add(1000);
        lineData3.add(1100);
        lineData3.add(1500);

        cryptoWalletArrayList.add(new CryptoWallet("bitcoin", "BTX", 1234.12, 2.13,lineData,1234.12,0.12343));
        cryptoWalletArrayList.add(new CryptoWallet("ethereum", "ETH", 3243.34, -1.33,lineData2,4543.23,0.4543));
        cryptoWalletArrayList.add(new CryptoWallet("trox", "ROX", 1234.12, 0.13,lineData3,1234.12,0.12343));

        adapter = new CryptoWalletAdapter(cryptoWalletArrayList);
        recyclerView.setAdapter(adapter);
    }
}

