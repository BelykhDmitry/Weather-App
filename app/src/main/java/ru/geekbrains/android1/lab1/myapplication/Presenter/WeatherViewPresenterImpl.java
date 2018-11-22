package ru.geekbrains.android1.lab1.myapplication.Presenter;

import ru.geekbrains.android1.lab1.myapplication.Model.Interactor;
import ru.geekbrains.android1.lab1.myapplication.Model.OnDataChangedListener;
import ru.geekbrains.android1.lab1.myapplication.Model.WeatherDataAdapter;
import ru.geekbrains.android1.lab1.myapplication.View.WeatherView;

public class WeatherViewPresenterImpl implements WeatherViewPresenter, OnDataChangedListener {

    private WeatherDataAdapter adapter;
    private WeatherView view;
    private Interactor interactor;

    public WeatherViewPresenterImpl(WeatherDataAdapter adapter, WeatherView view, Interactor interactor) {
        this.adapter = adapter;
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void handleOnCreate() {
        view.init();
    }

    @Override
    public void handleOnStart() {
        //interactor.subscribe(this);
    }

    @Override
    public void handleOnStop() {
        //interactor/unsubscribe(this);
    }

    @Override
    public void onDataChanged() {
        adapter.setEntity(interactor.getEntity());
        view.update(adapter);
    }

    @Override
    public void onError() {
    }
}
