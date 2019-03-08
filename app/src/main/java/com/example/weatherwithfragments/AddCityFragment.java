package com.example.weatherwithfragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.weatherwithfragments.cityrepository.CityRepository;


public class AddCityFragment extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_city, container, false);


        EditText addCity = v.findViewById(R.id.et_insert_city);
        Button saveReturn = v.findViewById(R.id.btn_save_and_return);


        if (getActivity() != null) {
            FloatingActionButton fab = getActivity().findViewById(R.id.fab);
            fab.hide();
        }

        saveReturn.setOnClickListener(v1 -> {
            if (getFragmentManager() != null) {
                getFragmentManager().popBackStack();
            }

            String t = addCity.getText().toString();
            CityRepository.addItem(CityRepository.createTheCity(CityRepository.ITEMS.size(), t,
                    "?", "?", "?", "?"));

            FloatingActionButton fab = getActivity().findViewById(R.id.fab);
            fab.show();


        });


        return v;
    }
}
