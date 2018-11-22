package ru.geekbrains.android1.lab1.myapplication;

import android.arch.lifecycle.Observer;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;


public class WeatherFragment extends Fragment implements Observer {

    private static final String TAG = "WeatherFragment";
    private WeatherInfo info;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView()");
        return inflater.inflate(R.layout.weather_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onActivityCreated()");
        WeatherProvider.getInstance().subscribe(this);
        super.onActivityCreated(savedInstanceState);
        TextView date = Objects.requireNonNull(getActivity()).findViewById(R.id.dayOfWeek);
        String str = Calendar.getInstance().getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault()) +
                " " + Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault()) +
                " " + Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        date.setText(str);
        if(savedInstanceState != null) {
            onChanged(savedInstanceState.getSerializable(TAG));
        }
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, "onDestroyView()");
        WeatherProvider.getInstance().unsubscribe(this);
        super.onDestroyView();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onChanged(@Nullable Object o) {
        Log.i(TAG, "onChanged()");
        info = (WeatherInfo)o;
        TextView temperature = getActivity().findViewById(R.id.temperature);
        TextView weather = getActivity().findViewById(R.id.location);
        TextView weatherConditions = getActivity().findViewById(R.id.weatherConditions);
        ImageView img = getActivity().findViewById(R.id.weather_background);

        String weatherField = getString(R.string.weather) + " " + info.getCity();
        String conditionsField = info.getHumidity() + "% " + info.getPressure() + " " + getString(R.string.pressure);
        weather.setText(weatherField);
        temperature.setText(info.getTemperature());
        weatherConditions.setText(conditionsField);
        TypedArray imgs = getResources().obtainTypedArray(R.array.Conditions);
        img.setImageResource(imgs.getResourceId(0, -1));

        ImageView weatherImage = getActivity().findViewById(R.id.weatherImage);
        Picasso.with(getActivity())
                .load(info.getImage())
                .into(weatherImage);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Log.i(TAG, "onSaveInstanceState");
        super.onSaveInstanceState(outState);
        outState.putSerializable(TAG, info);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }
}
