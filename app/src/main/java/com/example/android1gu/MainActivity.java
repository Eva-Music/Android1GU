package com.example.android1gu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android1gu.R.string.*;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "TAG";
    public static final String HUM = "hum";
    public static final String WIND = "wind";
    public static final String RESULT_COUNTER_TEXT = "text";
    public static final int REQUEST_CODE = 10;
    final ActivitySaver activitySaver = ActivitySaver.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String currentInstance;
        if (savedInstanceState == null) {
            currentInstance = "Первый запуск";
        } else {
            currentInstance = "Повторный запуск";
        }

        Log.d(TAG, "onCreate");
        Toast.makeText(this.getApplicationContext(), currentInstance + " onCreate", Toast.LENGTH_SHORT).show();

        downloadNextActivity();
        setText();
        incrementButtonJob();
    }

    public void downloadNextActivity() {
        final EditText editText = findViewById(R.id.edit_city);
        Button buttonResult = findViewById(R.id.button_result);
        final CheckBox checkBoxHumidity = findViewById(R.id.checkbox_humidity);
        final CheckBox checkBoxWind = findViewById(R.id.checkbox_wind);

        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activitySaver.setCity(editText.getText().toString());

                final Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                if (checkBoxHumidity.isChecked()) {
                    intent.putExtra(HUM, true);
                }
                if (checkBoxWind.isChecked()) {
                    intent.putExtra(WIND, true);
                }

                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @SuppressLint("DefaultLocale")
    public void setText() {
        TextView resultView = findViewById(R.id.text_view_quantity);
        resultView.setText(String.format("%s %d %s", getResources().getString(pushed),
                activitySaver.getCounter(), getResources().getString(times)));

    }

    public void incrementButtonJob() {
        final Button incrementButton = findViewById(R.id.button_counter);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activitySaver.incrementCounter();
                setText();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (data != null) {
            Toast.makeText(this.getApplicationContext(), data.getStringExtra(RESULT_COUNTER_TEXT) + " " +
                    activitySaver.getCity(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
