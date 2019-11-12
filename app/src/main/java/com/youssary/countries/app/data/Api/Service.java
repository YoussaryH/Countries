package com.youssary.countries.app.data.Api;

import com.youssary.countries.app.data.model.CountryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface Service
{
    String API_ROUTE = "rest/v2/all";

    @GET(API_ROUTE)
    Call<List<CountryResponse>> getItems();
}
