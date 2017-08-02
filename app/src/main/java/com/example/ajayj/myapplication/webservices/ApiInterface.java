package com.example.ajayj.myapplication.webservices;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by ajayj on 04-07-2017.
 */

public interface ApiInterface {
    @POST("drupalgap/user/login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);
}
