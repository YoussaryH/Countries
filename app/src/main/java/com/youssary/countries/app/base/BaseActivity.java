package com.youssary.countries.app.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import javax.inject.Inject;

public abstract class BaseActivity<T extends BasePresenter> extends BaseSimpleActivity
{
    @Inject
    protected T presenter;

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs)
    {
        if (presenter != null) {
            presenter.attachView(this);

        }
        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    protected void onDestroy()
    {
        if (presenter != null) {
            presenter.detachView();
        }
        super.onDestroy();
    }


    public BaseSimpleActivity getBaseActivity()
    {
        return this;
    }


}
