package com.example.apps.oktaatr.pdam_controlling.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    public static String BASE_URL = "http://192.168.43.16";

    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if (retrofit == null ){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
