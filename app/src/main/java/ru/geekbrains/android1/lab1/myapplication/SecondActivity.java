package ru.geekbrains.android1.lab1.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity {
    public static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        TextView date = findViewById(R.id.dayOfWeek);
        String str = Calendar.getInstance().getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.ENGLISH) + " " + Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.ENGLISH) + " " + Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        date.setText(str);

        MyParcel parcel = getIntent().getExtras().getParcelable(StartSecondActivity.TEXT);

        TextView temperature = findViewById(R.id.temperature);
        TextView weather = findViewById(R.id.weather);
        TextView weatherConditions = findViewById(R.id.weatherConditions);
        assert parcel != null;
        String weatherField = "Weather " + parcel.city;
        String conditionsField = parcel.humidity + "% " + parcel.pressure + "mm";
        weather.setText(weatherField);
        temperature.setText(parcel.temperature);
        weatherConditions.setText(conditionsField);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backButton:
                finish();
                break;

            default:
                break;
        }
    }
}
