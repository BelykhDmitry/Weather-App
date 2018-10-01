package ru.geekbrains.android1.lab1.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class StartSecondActivity implements View.OnClickListener {

    public final static String TEXT = "MyParcel";

    private final Activity sourceActivity;

    public StartSecondActivity(Activity sourceActivity){
        this.sourceActivity = sourceActivity;
    }

    @Override
    public void onClick(View v) {
        EditText city = sourceActivity.findViewById(R.id.cityInput);
        EditText temperature = sourceActivity.findViewById(R.id.temperatureInput);
        EditText humidity = sourceActivity.findViewById(R.id.humidityInput);
        EditText pressure = sourceActivity.findViewById(R.id.pressureInput);

        MyParcel parcel = new MyParcel(city.getText().toString(),
                temperature.getText().toString(),
                humidity.getText().toString(),
                pressure.getText().toString());

        Intent intent = new Intent(sourceActivity, SecondActivity.class);
        intent.putExtra(TEXT, parcel);
        sourceActivity.startActivity(intent);
    }
}
