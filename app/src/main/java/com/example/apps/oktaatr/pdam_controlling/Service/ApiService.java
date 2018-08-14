package com.example.apps.oktaatr.pdam_controlling.Service;

import com.example.apps.oktaatr.pdam_controlling.Model.LoginModel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class ApiService {
    public static String BASE_URL = "http://172.25.3.94";

    public static PostService service_post = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiService.PostService.class);

    public static GetService service_get = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiService.GetService.class);

    public interface PostService{

        @POST("laravelku/api/login")
        @FormUrlEncoded
        Call<LoginModel> postLogin(@Field("nip") String nip, @Field("password") String password);


    }

    public interface GetService {
    }
    }
