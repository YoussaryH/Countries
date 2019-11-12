package com.youssary.countries.country.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.youssary.countries.R;
import com.youssary.countries.app.App;
import com.youssary.countries.app.base.BaseActivity;
import com.youssary.countries.app.utils.EContants;
import com.youssary.countries.app.data.entities.CountryBean;
import com.youssary.countries.country.module.CountryComponent;
import com.youssary.countries.country.module.CountryModule;

import com.youssary.countries.country.module.DaggerDetailComponent;
import com.youssary.countries.country.module.DetailComponent;
import com.youssary.countries.country.module.DetailModule;
import com.youssary.countries.country.present.CountryActivityPresenter;
import com.youssary.countries.country.present.DetailCountryPresenter;
import com.youssary.countries.country.view.MVP.CountryActivityMVP;
import com.youssary.countries.country.view.MVP.DetailCountryMVP;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailCountry extends BaseActivity<DetailCountryPresenter> implements DetailCountryMVP.View, OnMapReadyCallback
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
    @BindView(R.id.imvFlagNomal)
    ImageView imvFlagNomal;
    @BindView(R.id.tvArea)
    TextView tvArea;
    @BindView(R.id.tvTraslatorGermany)
    TextView tvTraslatorGermany;
    @BindView(R.id.clMainDetail)
    ConstraintLayout clMainDetail;
    private CountryBean countryBean;

    private GoogleMap mMap;

    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_country);
        ButterKnife.bind(this);
        Context context = App.getAppComponent().getContext();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loadInten();
        loadData();
        loadMaps();

        getSupportActionBar().setTitle("Datos");


    }

    private void loadMaps()
    {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    protected void setupActivityComponent()
    {
        DetailComponent component = DaggerDetailComponent.builder()
                .detailModule(new DetailModule())
                .build();
        component.inject(this);
    }

    private void loadData()
    {
        tvCountry.setText(getString(R.string.country) + countryBean.getName());
        tvCapital.setText(getString(R.string.capital) + countryBean.getCapital());
        tvNativeName.setText(getString(R.string.native_name) + countryBean.getNativeName());
        tvArea.setText(getString(R.string.area) + countryBean.getArea() + "");
        tvRegion.setText(getString(R.string.region) + countryBean.getRegion() + "");
        tvLenguages.setText(getString(R.string.lenguage) + countryBean.getLanguagesSTR() + "");
        tvTraslatorGermany.setText(getString(R.string.traslation) + countryBean.getLanguagesComp() + "");

        Glide.with(this).load(Uri.parse(countryBean.getFlag()).toString()).apply(RequestOptions.fitCenterTransform()).into(imvFlagNomal);
    }

    private void loadInten()
    {
        countryBean = new CountryBean();
        countryBean = getIntent().getParcelableExtra(EContants.ITEM_COUNTRY_BEAN.value());
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
        if (countryBean != null) {
            List<Double> latiLng = countryBean.getLatlng();
            double lat = latiLng.get(0);
            double lon = latiLng.get(1);

            LatLng country = new LatLng(lat, lon);
            mMap.addMarker(new MarkerOptions()
                    .position(country)
                    .title(countryBean.getName() + getString(R.string.capital) + countryBean.getCapital()));

            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(country)
                    .zoom(4)
                    .tilt(30)
                    .build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }
    }

    @Override
    public void showProgress()
    {

    }

    @Override
    public void hideProgress()
    {

    }

}
