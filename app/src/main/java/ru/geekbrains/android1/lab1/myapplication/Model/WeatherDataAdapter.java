package ru.geekbrains.android1.lab1.myapplication.Model;

import ru.geekbrains.android1.lab1.myapplication.Model.WeatherRequest.CurrentWeather;

public interface WeatherDataAdapter {
    public void setEntity(CurrentWeather weather); // Точно ли так стоит делать?
    String getTemperature();
    String getHumidity();
    String getPressure();
    String getDate();
    String getLocation();
    //...
}
