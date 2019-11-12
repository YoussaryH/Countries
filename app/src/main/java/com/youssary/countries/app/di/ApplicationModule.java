package com.youssary.countries.app.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule
{
    private Application application;

    public ApplicationModule(Application application)
    {
        this.application = application;
    }

    @Provides
    @Singleton
    Application getApplication()
    {
        return application;
    }

    @Provides
    @ApplicationContext
    Context provideContext()
    {
        return application;
    }

    @Provides
    Application provideApplication()
    {
        return application;
    }
}
