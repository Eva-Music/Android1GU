package com.example.weatherwithfragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.weatherwithfragments.cityrepository.CityRepository;

public class MainActivity extends AppCompatActivity implements CityNameFragment.OnListFragmentInteractionListener {

    public static final String SERIAL = "serial";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        // .setAction("Action", null).show()




        CityNameFragment cityNameFragment = new CityNameFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.city_name_fragment, cityNameFragment)
                .commit();


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddCityFragment addCityFragment = new AddCityFragment();

                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.city_name_fragment, addCityFragment)
                            .addToBackStack(null)
                            .commit();
                }

                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.weather_fragment, addCityFragment)
                            .addToBackStack(null)
                            .commit();
                }

            }
        });
    }

    @Override
    public void onListFragmentInteraction(CityRepository.TheCity item) {
        Log.d("TAG", "onListFragmentInteraction: " + item);
        WeatherFragment weatherFragment = new WeatherFragment();
        CityNameFragment cityNameFragment = new CityNameFragment();
        Bundle bundle = new Bundle();
        FragmentManager fm = getSupportFragmentManager();
        bundle.putSerializable(SERIAL, item);
        weatherFragment.setArguments(bundle);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            fm.beginTransaction()
                    .replace(R.id.city_name_fragment, weatherFragment)
                    .addToBackStack("enter")
                    .commit();
        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            fm.beginTransaction()
                    .replace(R.id.weather_fragment, weatherFragment)
                    .replace(R.id.city_name_fragment, cityNameFragment)
                    .addToBackStack("enter")
                    .commit();
        }
    }
}
