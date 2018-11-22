package ru.geekbrains.android1.lab1.myapplication;

import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import ru.geekbrains.android1.lab1.myapplication.Model.Interactor;
import ru.geekbrains.android1.lab1.myapplication.Model.InteractorImpl;
import ru.geekbrains.android1.lab1.myapplication.Model.WeatherDataAdapter;
import ru.geekbrains.android1.lab1.myapplication.Model.WeatherDataAdapterImpl;
import ru.geekbrains.android1.lab1.myapplication.Presenter.CitiesViewPresenter;
import ru.geekbrains.android1.lab1.myapplication.Presenter.WeatherViewPresenter;
import ru.geekbrains.android1.lab1.myapplication.View.CitiesView;
import ru.geekbrains.android1.lab1.myapplication.View.CitiesViewImpl;
import ru.geekbrains.android1.lab1.myapplication.View.WeatherView;
import ru.geekbrains.android1.lab1.myapplication.View.WeatherViewImpl;

public class MainActivity extends AppCompatActivity {

    CitiesViewPresenter citiesViewPresenter;
    WeatherViewPresenter weatherViewPresenter;
    //TODO ForecastViewPresenter forecastViewPresenter;

    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init();
    }

    private void init() {
        Interactor interactor = new InteractorImpl();
        CitiesView citiesView = new CitiesViewImpl((ListFragment)getSupportFragmentManager().findFragmentById(R.id.cities));
        WeatherView weatherView = new WeatherViewImpl(this);
        WeatherDataAdapter weatherDataAdapter = new WeatherDataAdapterImpl();
        ArrayAdapter<String> citiesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, new ArrayList<>());
    }

}
