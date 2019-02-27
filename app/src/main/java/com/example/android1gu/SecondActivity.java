package com.example.android1gu;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.android1gu.R.string.*;

public class SecondActivity extends AppCompatActivity {

    final ActivitySaver activitySaver = ActivitySaver.getInstance();

    private Button backButton;
    private TextView secondView;
    private TextView textResultCounter;
    private ImageView humView;
    private ImageView windView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        unitUI();
        returnToPreviousActivityWithResult();
    }

    public void returnToPreviousActivityWithResult() {
        backButton = findViewById(R.id.button_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent resultIntent = new Intent();
        resultIntent.putExtra(MainActivity.RESULT_COUNTER_TEXT, getResources().getString(result_text));
        setResult(Activity.RESULT_OK, resultIntent);
    }

    @SuppressLint("DefaultLocale")
    public void unitUI() {
        secondView = findViewById(R.id.second_text_view);
        String city = activitySaver.getCity();
        secondView.append(" " + city);

        textResultCounter = findViewById(R.id.text_view_counter_result);
        textResultCounter.setText(String.format("%s %d %s", getResources().getString(previous),
                activitySaver.getCounter(), getResources().getString(times)));

        humView = findViewById(R.id.hum_picture);
        windView = findViewById(R.id.wind_picture);

        setVisible(MainActivity.HUM, humView);
        setVisible(MainActivity.WIND, windView);
    }


    public void setVisible(String tag, ImageView imageView) {
        if (getIntent() != null) {
            if (getIntent().getBooleanExtra(tag, false)) {
                imageView.setVisibility(View.VISIBLE);
            } else {
                imageView.setVisibility(View.INVISIBLE);
            }
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
