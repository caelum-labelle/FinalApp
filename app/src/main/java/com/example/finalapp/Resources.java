package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.card.MaterialCardView;

public class Resources extends AppCompatActivity {

    private MaterialCardView advice;

    private MaterialCardView become;

    private MaterialCardView state;

    private MaterialCardView cup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

        MaterialCardView advice = findViewById(R.id.advice);
        MaterialCardView become = findViewById(R.id.become);
        MaterialCardView state = findViewById(R.id.state);
        MaterialCardView cup = findViewById(R.id.advice);

        advice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://twitter.com/markminervini/status/1557922976191873024"; // Replace with the desired website URL
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        become.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://twitter.com/TradingComposur/status/1562243373729075201"; // Replace with the desired website URL
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://twitter.com/RaoulGMI/status/1561712351921016833"; // Replace with the desired website URL
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        cup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://twitter.com/SJosephBurns/status/1562243496811327488"; // Replace with the desired website URL
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}