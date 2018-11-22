package ru.geekbrains.android1.lab1.myapplication.View;

import android.widget.ArrayAdapter;

import ru.geekbrains.android1.lab1.myapplication.Presenter.CitiesViewListener;

public interface CitiesView {
    void init(CitiesViewListener listener, ArrayAdapter adapter);
    //void update();
}
