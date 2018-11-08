package ru.geekbrains.android1.lab1.myapplication.OpenWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.geekbrains.android1.lab1.myapplication.Model.CurrentWeather;

public interface OpenWeather {
    @GET("data/2.5/weather")
    Call<CurrentWeather> loadWeather(@Query("q") String cityCountry, @Query("units") String units , @Query("appid") String keyApi);

    // Добавить Get-запросы с прогнозом
}
