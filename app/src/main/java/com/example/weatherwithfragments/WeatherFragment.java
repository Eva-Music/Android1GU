package com.example.weatherwithfragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.weatherwithfragments.cityrepository.CityRepository;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeatherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeatherFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    ImageView picHum;
    ImageView picWind;
    Button backButton;

    public WeatherFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WeatherFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WeatherFragment newInstance(String param1, String param2) {
        WeatherFragment fragment = new WeatherFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_weather, container, false);
        picHum = v.findViewById(R.id.hum_picture);
        picWind = v.findViewById(R.id.wind_picture);
        backButton = v.findViewById(R.id.button_back);

        if (getArguments() != null) {
            if (getArguments().getSerializable(MainActivity.SERIAL) instanceof CityRepository.TheCity) {
                CityRepository.TheCity item = (CityRepository.TheCity) getArguments().getSerializable(MainActivity.SERIAL);
                if (item != null) {
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

        backButton.setOnClickListener(v1 -> {
            assert getFragmentManager() != null;
            getFragmentManager().popBackStack();
        });


        return v;
    }


}
