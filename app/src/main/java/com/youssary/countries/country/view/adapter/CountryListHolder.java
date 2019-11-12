package com.youssary.countries.country.view.adapter;


import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

;
import com.youssary.countries.R;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

class CountryListHolder extends RecyclerView.ViewHolder
{
    @BindView(R.id.tvCountry)
    TextView tvCountry;
    @BindView(R.id.tvNativeName)
    TextView tvNativeName;
    @BindView(R.id.tvRegion)
    TextView tvRegion;
    @BindView(R.id.tvCapital)
    TextView tvCapital;
    @BindView(R.id.tvLenguages)
    TextView tvLenguages;
    @BindView(R.id.tvArea)
    TextView tvArea;
    @BindView(R.id.tvTraslatorGermany)
    TextView tvTraslatorGermany;
    @BindView(R.id.clMainDetail)
    ConstraintLayout clMainDetail;
    @BindView(R.id.llCard)
    ConstraintLayout llCard;
    @BindView(R.id.view_foreground)
    CardView viewForeground;

    @BindView(R.id.imvFlagNomal)
    ImageView imvFlagNomal;
    @BindView(R.id.cdGeneral)
    CardView cdGeneral;

    private Context context;

    CountryListHolder(@NonNull View itemView)
    {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

}
