package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class VerifyOTP extends AppCompatActivity {

    private EditText Code1, Code2, Code3, Code4, Code5, Code6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);

        TextView textMobile = findViewById(R.id.textMobile);
        textMobile.setText(String.format(
                        "+63-%s", getIntent().getStringExtra("mobile")
        ));

        Code1 = findViewById(R.id.code1);
        Code2 = findViewById(R.id.code2);
        Code3 = findViewById(R.id.code3);
        Code4 = findViewById(R.id.code4);
        Code5 = findViewById(R.id.code5);
        Code6 = findViewById(R.id.code6);

        setupOTPInputs();
    }

    private void setupOTPInputs() {
        Code1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    Code1.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        Code2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    Code2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        Code3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    Code3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        Code4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    Code4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        Code5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    Code5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}