package com.youssary.countries.country.module;

import com.youssary.countries.country.present.CountryActivityPresenter;
import com.youssary.countries.country.repository.CountryRepository;
import com.youssary.countries.country.repository.CountryRepositoryInt;

import dagger.Module;
import dagger.Provides;

@Module
public class CountryModule
{
    @Provides
    CountryActivityPresenter provideCountryActivityPresenter(CountryRepositoryInt countryRepositoryInt)
    {
        return new CountryActivityPresenter(countryRepositoryInt);
    }


    @Provides
    CountryRepositoryInt provideCountryRepositoryInt()
    {
        return new CountryRepository();
    }

}
