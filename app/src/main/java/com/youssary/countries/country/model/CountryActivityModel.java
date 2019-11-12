package com.youssary.countries.country.model;

import com.youssary.countries.app.data.entities.CountryBean;
import com.youssary.countries.country.repository.CountryRepositoryInt;
import com.youssary.countries.country.view.MVP.CountryActivityMVP;

import java.util.ArrayList;

public class CountryActivityModel implements CountryActivityMVP.Model
{
    private CountryRepositoryInt repository;

    public CountryActivityModel(CountryRepositoryInt countryRepository)
    {
        this.repository = countryRepository;
    }

    @Override
    public CountryBean findUser(String nameCountry)
    {
        return repository.getCountry(nameCountry);
    }

    @Override
    public ArrayList<CountryBean> findUserSTR()
    {
        return repository.getCountrySTR();
    }
}
