package com.coolweathermine.android.Weather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Tony on 2017/4/30.
 */

public class Weather {

    public String status;

    public Basic basic;

    public AQI aqi;

    public Now now;

    public Suggestion suggestion;

    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;

}
