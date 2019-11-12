package com.youssary.countries.app.widget;

import android.content.Context;
import android.widget.AdapterView;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.youssary.countries.R;
import com.youssary.countries.app.data.entities.CountryBean;
import com.youssary.countries.country.repository.CountryRepository;

import java.util.List;


class AccountWidgetRemoteViewFactory implements RemoteViewsService.RemoteViewsFactory
{

    private Context context;
    private List<CountryBean> listAccount;
    private CountryRepository countryRepository;

    AccountWidgetRemoteViewFactory(Context applicationContext)
    {
        context = applicationContext;
        countryRepository = new CountryRepository();
    }

    @Override
    public void onCreate()
    {
        listAccount = countryRepository.getCountrySTR();
    }

    @Override
    public void onDataSetChanged()
    {

    }

    @Override
    public void onDestroy()
    {
        listAccount = null;
    }

    @Override
    public int getCount()
    {
        return listAccount == null ? 0 : listAccount.size();
    }

    @Override
    public RemoteViews getViewAt(int position)
    {
        if (position == AdapterView.INVALID_POSITION ||
                listAccount == null || listAccount.size() < position) {
            return null;
        }

        RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.country_widget_item);
        rv.setTextViewText(R.id.tvCountry, listAccount.get(position).getName());
        rv.setTextViewText(R.id.tvNativeName, listAccount.get(position).getNativeName());
        rv.setTextViewText(R.id.tvRegion, listAccount.get(position).getRegion());
        rv.setTextViewText(R.id.tvCapital, listAccount.get(position).getCapital());
        rv.setTextViewText(R.id.tvArea, listAccount.get(position).getArea()+"");
        rv.setTextViewText(R.id.tvLenguages, listAccount.get(position).getLanguagesSTR()+"");
        rv.setTextViewText(R.id.tvTraslatorGermany, listAccount.get(position).getTranslationsDE()+"");



        //rv.setTextViewText(R.id.tvStatus, listAccount.get(position).getPopulation(context));


        return rv;
    }

    @Override
    public RemoteViews getLoadingView()
    {
        return null;
    }

    @Override
    public int getViewTypeCount()
    {
        return 1;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public boolean hasStableIds()
    {
        return true;
    }
}