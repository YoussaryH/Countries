package com.youssary.countries.country.repository;

import com.youssary.countries.app.data.entities.CountryBean;

import java.util.ArrayList;
import java.util.List;

public interface CountryRepositoryInt
{
    CountryBean getCountry(String nameCountry);

    ArrayList<CountryBean> getCountrySTR();

    List<CountryBean> getDataCountry(String nameCountry);
}
