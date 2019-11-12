package com.youssary.countries.app.base;

import javax.inject.Inject;

public class BasePresenter<T>
{
    protected String TAG;
    private T mView;

    void attachView(T view)
    {
        this.mView = view;

    }

    void detachView()
    {
        if (mView != null) {
            mView = null;
        }
    }

    protected boolean isViewAttached()
    {
        return mView != null;
    }

    protected T getView()
    {
        return mView;
    }

    @Inject
    void setView(T mView)
    {
        this.mView = mView;
    }
}


