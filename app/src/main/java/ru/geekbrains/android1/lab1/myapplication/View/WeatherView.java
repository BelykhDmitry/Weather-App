package ru.geekbrains.android1.lab1.myapplication.View;

import ru.geekbrains.android1.lab1.myapplication.Model.WeatherDataAdapter;

public interface WeatherView {
    void init();
    void update(WeatherDataAdapter adapter);
}
