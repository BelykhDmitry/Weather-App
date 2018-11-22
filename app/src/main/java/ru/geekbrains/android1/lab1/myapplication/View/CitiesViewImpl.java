package ru.geekbrains.android1.lab1.myapplication.View;

import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import ru.geekbrains.android1.lab1.myapplication.Presenter.CitiesViewListener;

public class CitiesViewImpl implements CitiesView {

    private ListFragment fragment;
    private CitiesViewListener listener;

    public CitiesViewImpl(ListFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void init(CitiesViewListener listener, ArrayAdapter adapter) {
        this.listener = listener;
        fragment.setListAdapter(adapter);
    }
}
