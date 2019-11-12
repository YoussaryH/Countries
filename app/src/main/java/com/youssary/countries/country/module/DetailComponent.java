package com.youssary.countries.country.module;

import com.youssary.countries.country.view.DetailCountry;

import dagger.Component;

@Component(modules = DetailModule.class)
public interface DetailComponent
{
    void inject(DetailCountry activity);
}