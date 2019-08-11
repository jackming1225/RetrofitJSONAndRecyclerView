package com.sunny.nobroker.model;

import java.util.List;

public class MyResponse {

    private List<WeatherData> data;

    public List<WeatherData> getData() {
        return data;
    }

    public void setData(List<WeatherData> data) {
        this.data = data;
    }
}
