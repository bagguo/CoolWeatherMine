package com.coolweathermine.android.Weather.util;

import android.text.TextUtils;
import android.util.Log;

import com.coolweathermine.android.Weather.db.City;
import com.coolweathermine.android.Weather.db.County;
import com.coolweathermine.android.Weather.db.Province;
import com.coolweathermine.android.Weather.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.content.ContentValues.TAG;

/**
 * Created by Tony on 2017/4/30.
 */

public class Utility {
    /**
     * 解析处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {//判断非空
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                    Log.i(TAG, "handleProvinceResponse: ------>"+province.getProvinceName());

                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

     /**
     * 处理和解析服务器返回的市级数据
     * @param reponse json数据
     * @param provinceId 省份id
     * @return
     */
    public static boolean handleCityResponse(String reponse,int provinceId) {
        if (!TextUtils.isEmpty(reponse)) {
            try {
                JSONArray allCities = new JSONArray(reponse);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                    Log.i(TAG, "handleCityResponse: ---------->"+city.getCityName());
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回县的数据
     * @param reponse
     * @param cityId
     * @return
     */
    public static boolean handleCountyResponse(String reponse, int cityId) {
        if (!TextUtils.isEmpty(reponse)) {
            try {
                JSONArray allCounties = new JSONArray(reponse);
                for (int i = 0; i < allCounties.length(); i++) {
                    JSONObject countyObject=allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                    Log.i(TAG, "handleCountryResponse: ------->"+county.getCountyName());
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
    /**
     * 将返回的json数据解析成weather实体类
     */
    public static Weather handleWeatherResponse(String response){

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent, Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
