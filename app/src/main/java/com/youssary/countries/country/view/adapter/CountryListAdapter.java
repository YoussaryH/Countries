package com.youssary.countries.country.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.PictureDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.youssary.countries.R;
import com.youssary.countries.app.base.BaseAdapter;
import com.youssary.countries.app.utils.EContants;
import com.youssary.countries.app.data.entities.CountryBean;
import com.youssary.countries.country.view.DetailCountry;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryListAdapter extends BaseAdapter
{

    private Context context;
    private RequestBuilder<PictureDrawable> requestBuilder;
    private CountryBean item;

    public CountryListAdapter(List<CountryBean> list, Context context)
    {
        TAG = getClass().getSimpleName();
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CountryListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list_account, parent, false);
        return new CountryListHolder(row);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int position)
    {
        item = (CountryBean) list.get(position);
        try {
            if (item != null) {
                final CountryListHolder holder = (CountryListHolder) viewHolder;
                holder.imvFlagNomal.setVisibility(View.GONE);
                holder.tvCountry.setText(context.getString(R.string.country) + item.getName());
                holder.tvCapital.setText(context.getString(R.string.capital) + item.getCapital());
                holder.tvNativeName.setText(context.getString(R.string.native_name) + item.getNativeName());
                holder.tvArea.setText(context.getString(R.string.area) + item.getArea() + "");
                holder.tvRegion.setText(context.getString(R.string.region) + item.getRegion() + "");
                holder.tvLenguages.setText(context.getString(R.string.lenguage) + item.getLanguagesSTR() + "");
                holder.tvTraslatorGermany.setText(context.getString(R.string.traslation) + item.getTranslationsDE() + "");

                String url = item.getFlag();

              /*  Glide.with(context)
                        .load(url)
                        .placeholder(R.drawable.load)
                        .into(holder.imvFlagNomal);*/

                //on item click
                holder.viewForeground.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        int pos = holder.getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION) {
                            CountryBean valueItem = setItem((CountryBean) list.get(pos));

                            Intent intent = new Intent(context, DetailCountry.class);
                            intent.putExtra(EContants.ITEM_COUNTRY_BEAN.value(), valueItem);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);
                        }
                    }

                });
            }
        } catch (Exception e) {
            Log.e(TAG, ".onBindViewHolder ->" + e.getMessage());
        }
    }

    private CountryBean setItem(CountryBean items)
    {
        CountryBean data = new CountryBean();
        data.setName(items.getName());
        data.setArea(items.getArea());
        data.setCapital(items.getCapital());
        data.setRegion(items.getRegion());
        data.setNativeName(items.getNativeName());
        data.setLatlng(items.getLatlng());
        data.setTranslations(items.getTranslations());
        data.setLanguages(items.getLanguages());
        data.setFlag(items.getFlag());

        return data;
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public void setList(List<CountryBean> list)
    {
        this.list = list;
        notifyDataSetChanged();
    }


}

