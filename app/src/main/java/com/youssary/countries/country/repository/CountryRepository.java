package com.youssary.countries.country.repository;

import android.content.Context;
import android.util.Log;

import com.youssary.countries.app.data.Api.Client;
import com.youssary.countries.app.data.Api.Service;
import com.youssary.countries.app.App;
import com.youssary.countries.app.data.entities.CountryBean;
import com.youssary.countries.app.data.model.CountryResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryRepository implements CountryRepositoryInt
{
    private Context context;

    public CountryRepository()
    {
        if (context != null) {
            this.context = App.getAppComponent().getContext();
        }
    }

    ArrayList<CountryBean> items = new ArrayList<>();

    @Override
    public CountryBean getCountry(String nameCountry)
    {
        return null;
    }

    @Override
    public ArrayList<CountryBean> getCountrySTR()
    {
        ArrayList<CountryBean> stringList = new ArrayList<>();

        stringList = getDataCountry("");

        return stringList;
    }

    @Override
    public ArrayList<CountryBean> getDataCountry(String nameCountry)
    {

        try {
            Client client = new Client();
            Service apiService =
                    client.getClient().create(Service.class);
            Call<List<CountryResponse>> call = apiService.getItems();
            call.enqueue(new Callback<List<CountryResponse>>()
            {
                @Override
                public void onResponse(Call<List<CountryResponse>> call, Response<List<CountryResponse>> response)
                {
                    String errormsg = response.message();
                    if (!response.isSuccessful()) {
                        String error = "no error";
                    } else {
                        for (CountryResponse list : response.body()) {
                            CountryBean listCountryBean = new CountryBean();
                            listCountryBean.setName(list.getName());
                            listCountryBean.setNativeName(list.getNativeName());
                            listCountryBean.setRegion(list.getRegion());
                            listCountryBean.setCapital(list.getCapital());
                            listCountryBean.setArea(list.getArea());
                            listCountryBean.setLanguages(list.getLanguages());
                            listCountryBean.setTranslations(list.getTranslations());
                            listCountryBean.setFlag(list.getFlag());
                            listCountryBean.setLatlng(list.getLatlng());


                            items.add(listCountryBean);
                        }

                    }
                }

                @Override
                public void onFailure(Call<List<CountryResponse>> call, Throwable t)
                {
                    String error = "error";
                }
            });

        } catch (
                Exception e) {
            Log.d("Error", e.getMessage());
        }
        return items;

    }

}
