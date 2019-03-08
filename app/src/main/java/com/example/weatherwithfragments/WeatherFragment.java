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

    private ImageView picHum;
    private ImageView picWind;
    private Button backButton;
    private TextView textView;
    private char d = 176;

    private TextView dayTemp;
    private TextView nightTemp;
    private TextView humProcent;
    private TextView windSpeed;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_weather, container, false);
        picHum = v.findViewById(R.id.hum_picture);
        picWind = v.findViewById(R.id.wind_picture);
        backButton = v.findViewById(R.id.button_back);
        textView = v.findViewById(R.id.weather_text_view);

        dayTemp = v.findViewById(R.id.tv_day_temp);
        nightTemp = v.findViewById(R.id.tv_night_temp);
        humProcent = v.findViewById(R.id.tv_hum);
        windSpeed = v.findViewById(R.id.tv_wind);


        if (getArguments() != null) {
            if (getArguments().getSerializable(MainActivity.SERIAL) instanceof CityRepository.TheCity) {
                CityRepository.TheCity item = (CityRepository.TheCity) getArguments().getSerializable(MainActivity.SERIAL);
                if (item != null) {

                    dayTemp.setText(item.tempDay);
                    dayTemp.append(String.valueOf(d + "C"));
                    nightTemp.setText(item.tempNight);
                    nightTemp.append(String.valueOf(d + "C"));

                    textView.append(" " + item.content);
                    if (item.isWind()) {
                        picWind.setVisibility(View.VISIBLE);
                        windSpeed.setText(item.windSpeed);

                    } else {
                        picWind.setVisibility(View.INVISIBLE);
                    }

                    if (item.isHumid()) {
                        picHum.setVisibility(View.VISIBLE);
                        humProcent.setText(item.humProc);
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
