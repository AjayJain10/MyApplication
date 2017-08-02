package com.example.ajayj.myapplication.webservices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ajayj on 04-07-2017.
 */

public class ApiClient{
public static final String BASE_URL="https://kirana11g2t3mzfmnb.devcloud.acquia-sites.com/";//Dev
    public static Retrofit retrofitHeader=null;

    public static Retrofit getClient()
    {
        if(retrofitHeader==null)
        {
            retrofitHeader =new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
            return retrofitHeader;
    }
}
