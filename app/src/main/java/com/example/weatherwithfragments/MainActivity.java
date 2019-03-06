package com.example.weatherwithfragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.weatherwithfragments.cityrepository.CityRepository;

public class MainActivity extends AppCompatActivity implements CityNameFragment.OnListFragmentInteractionListener{

    public static final String SERIAL = "serial";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CityNameFragment cityNameFragment = new CityNameFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.city_name_fragment, cityNameFragment)
                .commit();

    }

    @Override
    public void onListFragmentInteraction(CityRepository.TheCity item) {
        Log.d("TAG", "onListFragmentInteraction: " + item);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            WeatherFragment weatherFragment = new WeatherFragment();
            Bundle bundle = new Bundle();

            FragmentManager fm = getSupportFragmentManager();

            bundle.putSerializable(SERIAL, item);

            weatherFragment.setArguments(bundle);
            fm.beginTransaction()
                    .replace(R.id.city_name_fragment, weatherFragment)
                    .addToBackStack("enter")
                    .commit();


        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            WeatherFragment weatherFragment = new WeatherFragment();
            Bundle bundle = new Bundle();

            FragmentManager fm = getSupportFragmentManager();

            bundle.putSerializable(SERIAL, item);

            weatherFragment.setArguments(bundle);
            fm.beginTransaction()
                    .add(R.id.weather_fragment, weatherFragment)
                    .addToBackStack("enter")
                    .commit();


        }
    }
}
