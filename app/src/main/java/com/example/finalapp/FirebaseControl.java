package com.example.finalapp;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseControl {
        String crypto, userName, itemName;
        FirebaseDatabase db;
        DatabaseReference myRef;

        public FirebaseControl() {
            db = FirebaseDatabase.getInstance("https://final-app-19fb2-default-rtdb.firebaseio.com/");
        }

        public void GetShopImages() {

        }

        public void AddCrypto(HomeCryptoData data) {
            db = FirebaseDatabase.getInstance();
            myRef = db.getReference("Crypto");
            crypto = data.getCryptoname();
            myRef.child(crypto).setValue(data);
        }

}
