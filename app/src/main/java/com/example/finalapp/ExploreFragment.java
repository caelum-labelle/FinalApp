package com.example.finalapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class ExploreFragment extends Fragment {
    private TextView tnews;
    private TextView tech;
    private TextView strat;
    private TextView morestrat;
    private MaterialCardView first;
    private MaterialCardView fi;
    private MaterialCardView fff;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        tnews = view.findViewById(R.id.tnews);
        tech = view.findViewById(R.id.tech);
        strat = view.findViewById(R.id.strat);
        morestrat = view.findViewById(R.id.morestrat);
        first = view.findViewById(R.id.first);
        fi = view.findViewById(R.id.fi);
        fff = view.findViewById(R.id.fff);

        tnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(getActivity(), Explore.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    // Handle any potential errors or exceptions here
                }
            }
        });


        tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Explore22.class);
                startActivity(intent);
            }
        });
        strat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Explore222.class);
                startActivity(intent);
            }
        });

        morestrat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Explore222.class);
                startActivity(intent);
            }
        });

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Explore3.class);
                startActivity(intent);
            }
        });

        fi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Explore33.class);
                startActivity(intent);
            }
        });

        fff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Explore33.class);
                startActivity(intent);
            }
        });

        return view;
    }
}