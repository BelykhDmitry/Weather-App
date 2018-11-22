package ru.geekbrains.android1.lab1.myapplication.Model;

import ru.geekbrains.android1.lab1.myapplication.Model.WeatherRequest.CurrentWeather;

public class WeatherDataAdapterImpl implements WeatherDataAdapter {

    private String temperature;
    private String humidity;
    private String pressure;
    private String date;
    private String location;

    @Override
    public void setEntity(CurrentWeather weather){        // Parse weather, get Date from calendar
    }

    @Override
    public String getTemperature() {
        return temperature;
    }

    @Override
    public String getHumidity() {
        return humidity;
    }

    @Override
    public String getPressure() {
        return pressure;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public String getLocation() {
        return location;
    }
}
