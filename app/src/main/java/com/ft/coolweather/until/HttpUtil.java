package com.ft.coolweather.until;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by djhj2009 on 17/9/1.
 */

public class HttpUtil {
    public static void sendOkHttpUtilRequest(String address, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);

    }
}
