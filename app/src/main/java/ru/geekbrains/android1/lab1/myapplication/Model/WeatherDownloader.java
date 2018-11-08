package ru.geekbrains.android1.lab1.myapplication.Model;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.geekbrains.android1.lab1.myapplication.OpenWeather.OpenWeather;

public class WeatherDownloader {

    private static WeatherDownloader instance = new WeatherDownloader();

    private OpenWeather openWeather;
    private final String KEY_API = "9b6c6f2b3827bd17210f813b4ebeaa41";
    private final String UNITS = "metric";

    private WeatherDownloader(){}

    public void initRetrofit() {
        if (openWeather == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.openweathermap.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            openWeather = retrofit.create(OpenWeather.class);
        }
    }

    public void requestRetrofit(String city, Callback<CurrentWeather> response) {
        openWeather.loadWeather(city, UNITS, KEY_API)
                .enqueue(response);
    }

    public static WeatherDownloader getInstance() {
        return instance;
    }
}
