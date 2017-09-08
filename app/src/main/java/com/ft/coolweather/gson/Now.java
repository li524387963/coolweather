package com.ft.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by djhj2009 on 17/9/6.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;
    @SerializedName("cond")
    public More more;
    public class More{
        @SerializedName("txt")
        public String info;
    }
}
