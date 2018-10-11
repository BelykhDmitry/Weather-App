package ru.geekbrains.android1.lab1.myapplication;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;

public class WeatherInfo implements Serializable {

    private final static String TAG = "weatherInfo";
    public final String city;
    public final String temperature;
    public final String humidity;
    public final String pressure;

    public WeatherInfo(String city, String temperature, String humidity, String pressure) {
        Log.d(TAG, "WeatherInfo create");
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }
}
