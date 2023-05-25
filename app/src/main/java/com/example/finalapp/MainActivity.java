package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.finalapp.Adapter.C_Adapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<HomeCryptoData> homeCryptoData = new ArrayList<>();

//    private RecyclerView.Adapter adapter;
//    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_home);

//        setContentView(R.layout.activity_main);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON);
//
//        ImageView logo = findViewById(R.id.logo);
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade);
//        logo.startAnimation(animation);

        //recyclerViewWallet();

//        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(getApplicationContext(), LoginSignup.class));
//            }
//        }, 2000);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

//    private void recyclerViewWallet() {
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerView = findViewById(R.id.viewactivities);
//        recyclerView.setLayoutManager(linearLayoutManager);
//
//        ArrayList<CryptoWallet> cryptoWalletArrayList = new ArrayList<>();
//        ArnerayList<Integer> lineData = new ArrayList<>();
//        liData.add(1000);
//        lineData.add(1100);
//        lineData.add(1200);
//        lineData.add(1300);
//
//        ArrayList<Integer> lineData2 = new ArrayList<>();
//        lineData2.add(2100);
//        lineData2.add(1200);
//        lineData2.add(2000);
//        lineData2.add(1900);
//
//        ArrayList<Integer> lineData3 = new ArrayList<>();
//        lineData3.add(900);
//        lineData3.add(1200);
//        lineData3.add(1000);
//        lineData3.add(1100);
//        lineData3.add(1500);
//
//        cryptoWalletArrayList.add(new CryptoWallet("bitcoin", "BTX", 1234.12, 2.13,lineData,1234.12,0.12343));
//        cryptoWalletArrayList.add(new CryptoWallet("ethereum", "ETH", 3243.34, -1.33,lineData2,4543.23,0.4543));
//        cryptoWalletArrayList.add(new CryptoWallet("trox", "ROX", 1234.12, 0.13,lineData3,1234.12,0.12343));
//
//        adapter = new CryptoWalletAdapter(cryptoWalletArrayList);
//        recyclerView.setAdapter(adapter);
//    }

    private void setupHomeCryptoData() {
        String[] cryptonames = getResources().getStringArray(R.array.crypto_name_text);
        String[] lastprice = getResources().getStringArray(R.array.last_price_text);
        String[] changes = getResources().getStringArray(R.array.changes_text);

        for(int i = 0; i < cryptonames.length; i++) {
            homeCryptoData.add(new HomeCryptoData(cryptonames[i],lastprice[i],changes[i]));
        }
    }
}

