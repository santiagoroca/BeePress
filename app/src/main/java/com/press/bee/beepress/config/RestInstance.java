package com.press.bee.beepress.config;

import android.app.Application;
import com.press.bee.beepress.base.IRest;

import retrofit.RestAdapter;


public class RestInstance extends Application {

    public static final String BASE_URL = "http://192.168.1.101/mockapi";
    public static IRest rInterface;
    RestAdapter restAdapter;

    public RestInstance () {
        restAdapter = new RestAdapter.Builder().setServer(BASE_URL).build();
        rInterface = restAdapter.create(IRest.class);
    }

}
