package com.fazil.units.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fazil.units.ConvertActivity;
import com.fazil.units.HomeActivity;
import com.fazil.units.R;

public class HomeFragment extends Fragment {

    CardView unitArea, unitLength, unitVolume, unitWeight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize Views.
        unitArea = view.findViewById(R.id.cardview_unit_area);
        unitLength = view.findViewById(R.id.cardview_unit_length);
        unitWeight = view.findViewById(R.id.cardview_unit_weight);
        unitVolume = view.findViewById(R.id.cardview_unit_volume);

        // Function Calling.
        unitArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToConvertActivity("area");
            }
        });

        unitLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToConvertActivity("length");
            }
        });

        unitVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToConvertActivity("volume");
            }
        });

        unitWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToConvertActivity("weight");
            }
        });

        return view;
    }

    private void navigateToConvertActivity(String unit){
        Intent intent = new Intent(requireActivity(), ConvertActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("unit", unit);
        startActivity(intent);
        // * New Activity Animation, Current Activity Animation.
        requireActivity().overridePendingTransition(R.anim.intent_enter_animation, R.anim.intent_no_animation);
    }
}