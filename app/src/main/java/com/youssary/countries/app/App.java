package com.youssary.countries.app;



import android.app.Application;

import com.youssary.countries.app.di.ApplicationComponent;
import com.youssary.countries.app.di.ApplicationModule;
import com.youssary.countries.app.di.DaggerApplicationComponent;


public class App extends Application
{
    private static  ApplicationComponent component;

    @Override
    public void onCreate()
    {
        super.onCreate();
        initDagger();

    }


    public ApplicationComponent getComponent()
    {
        return component;
    }


    private void initDagger()
    {
        component = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();

        component.inject(this);
    }

    public static ApplicationComponent getAppComponent()
    {
        return component;
    }
}
