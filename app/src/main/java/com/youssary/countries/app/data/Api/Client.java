package com.youssary.countries.app.data.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client
{
    public static final String BASE_URL = "https://restcountries.eu/";
    public static Retrofit retrofit = null;

    public static Retrofit getClient()
    {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
