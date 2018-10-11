package ru.geekbrains.android1.lab1.myapplication;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;

public class WeatherInfo implements Serializable {

    private final static String TAG = "weatherInfo";
    private final String city;
    private final String temperature;
    private final String humidity;
    private final String pressure;

    public WeatherInfo(String city, String temperature, String humidity, String pressure) {
        Log.d(TAG, "WeatherInfo create");
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public String getCity() {
        return city;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getPressure() {
        return pressure;
    }
}
