package com.sunny.nobroker;

import android.view.View;

import com.sunny.nobroker.model.WeatherData;


public interface RecyclerItemOnClickListener {
    void itemClicked(View view, int position, WeatherData weatherData);
}
