package com.ft.coolweather.until;

import android.text.TextUtils;
import android.util.Log;

import com.ft.coolweather.db.City;
import com.ft.coolweather.db.Couty;
import com.ft.coolweather.db.Province;
import com.ft.coolweather.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by djhj2009 on 17/9/4.
 */

public class Utility {
    //解析和处理服务器返回的省级数据
    public static boolean handleProvinceResponse(String response){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                    Log.d("Utility", "handleProvinceResponse: "+province);
                }

                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    //解析和处理服务器返回的市级数据
    public static boolean handleCityResponse(String response, int provinceId){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    //解析和处理服务器返回的县级数据
    public static boolean handleCountyResponse(String response,int cityId){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties = new JSONArray(response);
                for (int i = 0; i < allCounties.length(); i++) {
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    Couty county = new Couty();
                    county.setCityId(cityId);
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.save();

                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static Weather handleWeatherResponse(String response){
        Log.d("Utility", "handleWeatherResponse: "+response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String wetherContent = jsonArray.getJSONObject(0).toString();
            Log.d("Utility", "handleWeatherResponse: "+wetherContent);
            return new Gson().fromJson(wetherContent,Weather.class);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


}
