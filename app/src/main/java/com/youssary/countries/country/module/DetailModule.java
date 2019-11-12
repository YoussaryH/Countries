package com.youssary.countries.country.module;

import com.youssary.countries.country.present.DetailCountryPresenter;


import dagger.Module;
import dagger.Provides;

@Module
public class DetailModule
{
    @Provides
    DetailCountryPresenter provideDetailCountryPresenter()
    {
        return new DetailCountryPresenter();
    }

}
