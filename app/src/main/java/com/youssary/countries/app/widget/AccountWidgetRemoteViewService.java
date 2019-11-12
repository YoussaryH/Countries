package com.youssary.countries.app.widget;

import android.content.Intent;
import android.widget.RemoteViewsService;

public class AccountWidgetRemoteViewService extends RemoteViewsService
{

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent)
    {
        return new AccountWidgetRemoteViewFactory(this.getApplicationContext());
    }
}