package com.example.weatherwithfragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.weatherwithfragments.cityrepository.CityRepository;

public class MainActivity extends AppCompatActivity implements CityNameFragment.OnListFragmentInteractionListener{

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
    }
}
