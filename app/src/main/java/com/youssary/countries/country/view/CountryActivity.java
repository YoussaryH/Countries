package com.youssary.countries.country.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.youssary.countries.R;
import com.youssary.countries.app.base.BaseActivity;
import com.youssary.countries.country.module.CountryComponent;
import com.youssary.countries.country.module.CountryModule;
import com.youssary.countries.country.module.DaggerCountryComponent;
import com.youssary.countries.app.data.entities.CountryBean;
import com.youssary.countries.country.present.CountryActivityPresenter;
import com.youssary.countries.country.view.MVP.CountryActivityMVP;

import com.youssary.countries.country.view.adapter.CountryListAdapter;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CountryActivity extends BaseActivity<CountryActivityPresenter> implements CountryActivityMVP.View, TextWatcher
{


    @BindView(R.id.separador1)
    LinearLayout separador1;
    @BindView(R.id.edtfindCountry)
    EditText edtfindCountry;
    @BindView(R.id.btnCancel)
    ImageButton btnCancel;
    @BindView(R.id.activity_home_app)
    LinearLayout activityHomeApp;
    @BindView(R.id.lyFind)
    LinearLayout lyFind;
    @BindView(R.id.ryListCountry)
    RecyclerView ryListCountry;

    private CountryListAdapter countryListAdapter;
    private List<CountryBean> list;

    private ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView()
    {
        ButterKnife.bind(this);
        setFirstTime(true);
        edtfindCountry.addTextChangedListener(this);

    }

    @Override
    protected void setupActivityComponent()
    {
        CountryComponent component = DaggerCountryComponent.builder()
                .countryModule(new CountryModule())
                .build();
        component.inject(this);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        if (getBaseActivity().isFirstTime()) {
            presenter.loadAccountList(true);
        }

    }

    @Override
    public void showProgress()
    {
        pd = new ProgressDialog(this);
        pd.setMessage(getString(R.string.load));
        pd.setCancelable(false);
        pd.show();

    }

    @Override
    public void hideProgress()
    {
        pd.hide();
    }

    @Override
    public void setAccountList(List<CountryBean> list)
    {
        hideProgress();
        getBaseActivity().setFirstTime(false);
        this.list = list;
        initRecycler();
    }

    @Override
    public void updateAccountList(List<CountryBean> list)
    {
        hideProgress();
        getBaseActivity().setFirstTime(false);
        countryListAdapter.setList(list);
    }

    private void initRecycler()
    {
        try {
            if (list != null) {
                countryListAdapter = new CountryListAdapter(list, this);
                ryListCountry.setAdapter(countryListAdapter);
                ryListCountry.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            }
        } catch (Exception e) {
            Log.e(TAG, ".initRecycler -> " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void showError(String error)
    {
        showAlert(error, this);
    }

    @OnClick({ R.id.btnCancel })
    public void onClick(View view)
    {
        int id = view.getId();
        switch (id) {
            case R.id.btnCancel: {
                presenter.cancelSearch();
            }
            break;
        }
    }

    @Override
    public void setClearCountry()
    {
        this.edtfindCountry.setText("");
        presenter.filterList("");

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after)
    {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count)
    {

    }

    @Override
    public void afterTextChanged(Editable s)
    {
        presenter.filterList(edtfindCountry.getText().toString());
    }
}

