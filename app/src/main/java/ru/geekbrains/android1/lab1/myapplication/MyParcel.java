package ru.geekbrains.android1.lab1.myapplication;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class MyParcel implements Parcelable {

    public final static String TAG = "weatherParcel";
    public String city;
    public String temperature;
    public String humidity;
    public String pressure;

    public MyParcel(String city, String temperature, String humidity, String pressure) {
        Log.d(TAG, "MyParcel create");
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    protected MyParcel(Parcel in) {
        Log.d(TAG, "MyParcel(Parcel in)");
        this.city = in.readString();
        this.temperature = in.readString();
        this.humidity = in.readString();
        this.pressure = in.readString();
    }

    public static final Creator<MyParcel> CREATOR = new Creator<MyParcel>() {
        @Override
        public MyParcel createFromParcel(Parcel in) {
            Log.d(TAG, "createFromParcel");
            return new MyParcel(in);
        }

        @Override
        public MyParcel[] newArray(int size) {
            return new MyParcel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        Log.d(TAG, "writeToParcel");
        dest.writeString(this.city);
        dest.writeString(this.temperature);
        dest.writeString(this.humidity);
        dest.writeString(this.pressure);
    }
}
