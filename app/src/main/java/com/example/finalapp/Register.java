package com.example.finalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.DatabaseMetaData;

public class Register extends AppCompatActivity {

    //create objects of DatabaseReference class to access firebase's Realtime Database
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://final-app-19fb2-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText username = findViewById(R.id.username);
        final EditText phone = findViewById(R.id.phone);
        final EditText password = findViewById(R.id.password);
        final EditText confirmpass = findViewById(R.id.confirmpass);

        final Button register = findViewById(R.id.register);
        final TextView signin = findViewById(R.id.signin);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get data from EditTexts into String values
                final String usernameTxt = username.getText().toString();
                final String phoneTxt = phone.getText().toString();
                final String passTxt = password.getText().toString();
                final String conTxt = confirmpass.getText().toString();

                //check if user fill all the fields before sending data to firebase
                if (usernameTxt.isEmpty() || phoneTxt.isEmpty() || passTxt.isEmpty()) {
                    Toast.makeText(Register.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }

                //if passwords are not matching with each other
                else if (!passTxt.equals(conTxt)) {
                    Toast.makeText(Register.this, "Passwords are not matching", Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //check if phone is not register before
                            if (snapshot.hasChild(phoneTxt)) {
                                Toast.makeText(Register.this, "Phone is registere already", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                //sending data to firebase Realtime Database
                                //we are using phone number as unique identity of every user
                                databaseReference.child("users").child(phoneTxt).child("username").setValue(usernameTxt);
                                databaseReference.child("users").child(phoneTxt).child("password").setValue(passTxt);


                                Toast.makeText(Register.this, "User registered successfully.", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}