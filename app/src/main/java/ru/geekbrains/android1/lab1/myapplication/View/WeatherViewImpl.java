package ru.geekbrains.android1.lab1.myapplication.View;

import android.app.Activity;
import android.widget.TextView;

import ru.geekbrains.android1.lab1.myapplication.Model.WeatherDataAdapter;
import ru.geekbrains.android1.lab1.myapplication.R;

public class WeatherViewImpl implements WeatherView {

    private Activity activity;
    private TextView date;
    private TextView conditions;
    private TextView temperature;
    private TextView location;

    public WeatherViewImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void init() {
        date = activity.findViewById(R.id.dayOfWeek);
        conditions = activity.findViewById(R.id.weatherConditions);
        temperature = activity.findViewById(R.id.temperature);
        location = activity.findViewById(R.id.location);
    }

    @Override
    public void update(WeatherDataAdapter adapter) {
        date.setText(adapter.getDate());
        conditions.setText(String.format("%s%% %s %s", adapter.getHumidity(), adapter.getPressure(), activity.getResources().getString(R.string.pressure)));
        temperature.setText(adapter.getTemperature());
        location.setText(adapter.getLocation());
    }
}
