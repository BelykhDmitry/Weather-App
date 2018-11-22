package ru.geekbrains.android1.lab1.myapplication;

import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.geekbrains.android1.lab1.myapplication.Model.WeatherDownloader;
import ru.geekbrains.android1.lab1.myapplication.Model.WeatherRequest.CurrentWeather;

public class WeatherProvider {

    private final String TAG = this.getClass().getSimpleName();

    private final String WEATHER_IMG_ADDRESS = "http://openweathermap.org/img/w/";

    private static WeatherProvider instance = null;

    private WeatherInfo info = null;

    private List<Observer> observers = new ArrayList<>();

    private WeatherProvider() {}

    public static WeatherProvider getInstance() {
        if(instance == null)
            instance = new WeatherProvider();
        return instance;
    }

    public void setCity(String city) {
        WeatherDownloader.getInstance().initRetrofit();
        WeatherDownloader.getInstance().requestRetrofit(city, new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                if(response.body() != null) {
                    CurrentWeather currentWeather = response.body();
                    String imgAddr = WEATHER_IMG_ADDRESS + currentWeather.getWeather()[0].getIcon() + ".png";
                    info = new WeatherInfo(currentWeather.getName(),
                            String.valueOf(currentWeather.getMain().getTemp()),
                            String.valueOf(currentWeather.getMain().getHumidity()),
                            String.format(Locale.getDefault(), "%.2f",currentWeather.getMain().getPressure()/1.333),
                            imgAddr);
                    fireListeners();
                    Log.i(TAG, "response OK");
                } else {
                    Log.i(TAG, "response "+response.isSuccessful() + ": " + response.message());
                }

                // Через Picasso загрузить иконку http://openweathermap.org/img/w/10d.png
            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                // Подумать, как вывести тост с ошибкой
                Log.i(TAG, "response Fail:" + t.getMessage());
            }
        });

    }

    @NonNull
    public void subscribe(Observer o) {
        if(!observers.contains(o))
            observers.add(o);
    }

    @NonNull
    public void unsubscribe(Observer o) {
        observers.remove(o);
    }

    private void fireListeners() {
        for (Observer o:observers) {
            o.onChanged(info);
        }
    }
}
