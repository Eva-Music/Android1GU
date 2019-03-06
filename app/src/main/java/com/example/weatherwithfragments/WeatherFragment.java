package com.example.weatherwithfragments;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weatherwithfragments.cityrepository.CityRepository;

public class WeatherFragment extends Fragment {

    ImageView picHum;
    ImageView picWind;
    Button backButton;
    TextView textView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_weather, container, false);
        picHum = v.findViewById(R.id.hum_picture);
        picWind = v.findViewById(R.id.wind_picture);
        backButton = v.findViewById(R.id.button_back);
        textView = v.findViewById(R.id.weather_text_view);

        if (getArguments() != null) {
            if (getArguments().getSerializable(MainActivity.SERIAL) instanceof CityRepository.TheCity) {
                CityRepository.TheCity item = (CityRepository.TheCity) getArguments().getSerializable(MainActivity.SERIAL);
                if (item != null) {

                    textView.append(" " + item.content);
                    if (item.isWind()) {
                        picWind.setVisibility(View.VISIBLE);

                    } else {
                        picWind.setVisibility(View.INVISIBLE);
                    }

                    if (item.isHumid()) {
                        picHum.setVisibility(View.VISIBLE);

                    } else {
                        picHum.setVisibility(View.INVISIBLE);
                    }
                }
            }
        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            backButton.setOnClickListener(v1 -> {
                if (getFragmentManager() != null) {
                    getFragmentManager().popBackStack();
                }
            });
        } else {
            backButton.setVisibility(View.INVISIBLE);
        }

        return v;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (getArguments() != null) {
            CityRepository.TheCity item = (CityRepository.TheCity) getArguments().getSerializable(MainActivity.SERIAL);
            if (item != null) {
                item.setHumid(false);
            }
            if (item != null) {
                item.setWind(false);
            }
        }
    }
}
