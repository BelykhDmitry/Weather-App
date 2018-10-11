package ru.geekbrains.android1.lab1.myapplication;

import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class WeatherProvider {

    private static WeatherProvider instance = null;

    private WeatherInfo info = null;
    private String city = null;

    private List<Observer> observers = new ArrayList<Observer>();

    private WeatherProvider() {}

    public static WeatherProvider getInstance() {
        if(instance == null)
            instance = new WeatherProvider();
        return instance;
    }

    public void setCity(String city) {
        this.city = city;
        info = new WeatherInfo(city, "15", "55", "750");
        fireListeners();
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
