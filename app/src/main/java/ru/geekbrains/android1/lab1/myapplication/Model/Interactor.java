package ru.geekbrains.android1.lab1.myapplication.Model;

import ru.geekbrains.android1.lab1.myapplication.Model.WeatherRequest.CurrentWeather;

public interface Interactor {
    CurrentWeather getEntity(); //Тут тоже вопрос. Не универсально
    void subscribe(OnDataChangedListener listener);
    void unsubscribe(OnDataChangedListener listener);
}
