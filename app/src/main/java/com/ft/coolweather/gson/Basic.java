package com.ft.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by djhj2009 on 17/9/6.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;
    @SerializedName("id")
    public String weatherId;
    public Update update;
    public class Update {
        @SerializedName("loc")
        public String updateTime;
    }

}
