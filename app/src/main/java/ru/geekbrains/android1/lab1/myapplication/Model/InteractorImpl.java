package ru.geekbrains.android1.lab1.myapplication.Model;

import java.util.Set;

import ru.geekbrains.android1.lab1.myapplication.Model.WeatherRequest.CurrentWeather;

public class InteractorImpl implements Interactor {

    private Set<OnDataChangedListener> listeners;

    @Override
    public CurrentWeather getEntity() {
        return null;
    }

    @Override
    public void subscribe(OnDataChangedListener listener) {
        listeners.add(listener);
    }

    @Override
    public void unsubscribe(OnDataChangedListener listener) {
        listeners.remove(listener);
    }
}
