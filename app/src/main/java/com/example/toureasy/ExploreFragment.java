package com.example.toureasy;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.Toast;


public class ExploreFragment extends Fragment {

    View view;
    TableRow exploreView1,exploreView2,exploreView3,exploreView4,exploreView5,exploreView6,exploreView7;
    passHelper passer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_explore, container, false);
        passer = new passHelper();

        exploreView1 = (TableRow) view.findViewById(R.id.exploreView1);
        exploreView2 = (TableRow) view.findViewById(R.id.exploreView2);
        exploreView3 = (TableRow) view.findViewById(R.id.exploreView3);
        exploreView4 = (TableRow) view.findViewById(R.id.exploreView4);
        exploreView5 = (TableRow) view.findViewById(R.id.exploreView5);
        exploreView6 = (TableRow) view.findViewById(R.id.exploreView6);
        exploreView7 = (TableRow) view.findViewById(R.id.exploreView7);

        exploreView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getActivity(), "yo let's go", Toast.LENGTH_SHORT).show();
                passer.setId(1);
                Intent intent = new Intent(getContext(),exploreMore.class);
                startActivity(intent);
            }
        });

        exploreView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passer.setId(2);
                Intent intent = new Intent(getContext(),exploreMore.class);
                startActivity(intent);
            }
        });

        exploreView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passer.setId(3);
                Intent intent = new Intent(getContext(),exploreMore.class);
                startActivity(intent);
            }
        });

        exploreView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passer.setId(4);
                Intent intent = new Intent(getContext(),exploreMore.class);
                startActivity(intent);
            }
        });

        exploreView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passer.setId(5);
                Intent intent = new Intent(getContext(),exploreMore.class);
                startActivity(intent);
            }
        });

        exploreView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passer.setId(6);
                Intent intent = new Intent(getContext(),exploreMore.class);
                startActivity(intent);
            }
        });

        exploreView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passer.setId(7);
                Intent intent = new Intent(getContext(),exploreMore.class);
                startActivity(intent);
            }
        });

        return view;
    }
}