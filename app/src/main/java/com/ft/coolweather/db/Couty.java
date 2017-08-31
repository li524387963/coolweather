package com.ft.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by djhj2009 on 17/8/31.
 */

public class Couty extends DataSupport {
    private int coutyCode;
    private int id;
    private String countyName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCoutyCode() {
        return coutyCode;

    }

    public void setCoutyCode(int coutyCode) {
        this.coutyCode = coutyCode;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getCountyName() {
        return countyName;
    }

}
