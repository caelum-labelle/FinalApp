package com.example.finalapp;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;

public class ProfileFragment extends Fragment {

    private TextView usernameTextView;
    private Button logoutButton;
    private ShapeableImageView profileImageView;
    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int STORAGE_PERMISSION_REQUEST_CODE = 2;
    private Uri selectedImageUri;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        usernameTextView = view.findViewById(R.id.un);
        logoutButton = view.findViewById(R.id.logout);
        profileImageView = view.findViewById(R.id.prof);

        // Retrieve the username from SharedPreferences
        SharedPreferences preferences = getActivity().getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String username = preferences.getString("username", "");

        // Set the username in the TextView
        usernameTextView.setText(username);

        // Retrieve the selected image URI from SharedPreferences
        String imageUriString = preferences.getString("profileImageUri", null);
        if (imageUriString != null) {
            selectedImageUri = Uri.parse(imageUriString);
            //profileImageView.setImageURI(selectedImageUri);
            Glide.with(this).load(selectedImageUri).into(profileImageView);
        }

        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if the app has permission to read external storage
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    // Request the permission if it has not been granted
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            STORAGE_PERMISSION_REQUEST_CODE);
                } else {
                    // Launch the image picker
                    openImagePicker();
                }
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle logout button click event
                logout();
            }
        });

        return view;
    }

    private void logout() {
        SharedPreferences preferences = getActivity().getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        if (selectedImageUri != null) {
            editor.putString("profileImageUri", selectedImageUri.toString());
        } else {
            editor.remove("profileImageUri");
        }
        editor.apply();

        // Navigate to Login.java activity
        Toast.makeText(getActivity(), "Logout clicked", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), Login.class);
        startActivity(intent);
        getActivity().finish(); // Optional: Close the current activity (ProfileFragment) after logout
    }

    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            selectedImageUri = data.getData();
            profileImageView.setImageURI(selectedImageUri);

            // Save the selected image URI to SharedPreferences
            SharedPreferences preferences = getActivity().getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("profileImageUri", selectedImageUri.toString());
            editor.apply();
        }
    }


}
