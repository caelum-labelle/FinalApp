package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Calendar extends AppCompatActivity {

    TextView janTextView;
    TextView callTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        janTextView = findViewById(R.id.jan);
        callTextView = findViewById(R.id.call);

        janTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start Calendar2 activity
                Intent intent = new Intent(Calendar.this, Calendar2.class);
                startActivity(intent);
            }
        });

        callTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go back to ProfileFragment (assuming it is on the backstack)
                getSupportFragmentManager().popBackStack();
            }
        });
    }
}