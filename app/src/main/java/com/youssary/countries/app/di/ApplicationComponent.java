package com.youssary.countries.app.di;

import android.content.Context;


import com.youssary.countries.app.App;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class })
public interface ApplicationComponent
{
    void inject(App app);

    @ApplicationContext
    Context getContext();

}
