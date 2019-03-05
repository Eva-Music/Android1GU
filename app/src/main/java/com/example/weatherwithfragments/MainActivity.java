package com.example.weatherwithfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.weatherwithfragments.dummy.CityRepository;

public class MainActivity extends AppCompatActivity implements CityNameFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CityNameFragment cityNameFragment = new CityNameFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_layout, cityNameFragment)
                .commit();

    }

    @Override
    public void onListFragmentInteraction(CityRepository.TheCity item) {
        Log.d("TAG", "onListFragmentInteraction: " + item);
    }
}
