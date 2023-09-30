package com.fazil.units.fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fazil.units.HomeActivity;
import com.fazil.units.R;

public class HomeFragment extends Fragment {

    CardView unitArea;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        unitArea = view.findViewById(R.id.cardview_unit_area);
        unitArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment selectedFragment = new ConvertFragment();
                Bundle arguments = new Bundle();
                arguments.putString("unit", "area");
                selectedFragment.setArguments(arguments);
                ((HomeActivity) requireActivity()).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment).addToBackStack(null).commit();
            }
        });

        return view;
    }
}