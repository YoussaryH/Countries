package com.youssary.countries.country.module;

import com.youssary.countries.country.view.CountryActivity;

import dagger.Component;

@Component(modules = CountryModule.class)
public interface CountryComponent
{
  void  inject(CountryActivity activity);
}