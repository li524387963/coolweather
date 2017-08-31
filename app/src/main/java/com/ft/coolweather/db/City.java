package com.ft.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by djhj2009 on 17/8/31.
 */

public class City extends DataSupport{
    private int cityCode;
    private int id;
    private String cityName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public int getCityCode() {
        return cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
