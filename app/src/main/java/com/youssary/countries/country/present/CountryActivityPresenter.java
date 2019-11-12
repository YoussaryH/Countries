package com.youssary.countries.country.present;

import android.util.Log;

import com.youssary.countries.app.base.BaseRXPresenter;
import com.youssary.countries.app.data.entities.CountryBean;
import com.youssary.countries.country.repository.CountryRepositoryInt;
import com.youssary.countries.country.view.MVP.CountryActivityMVP;

import java.util.ArrayList;
import java.util.List;


public class CountryActivityPresenter extends BaseRXPresenter<CountryActivityMVP.View> implements CountryActivityMVP.Presenter
{
    private CountryRepositoryInt countryRepository;
    private ArrayList<CountryBean> listAccounts;
    private boolean isShowProgress;

    public CountryActivityPresenter(CountryRepositoryInt countryRepository)
    {
        this.TAG = getClass().getSimpleName();
        this.countryRepository = countryRepository;
    }


    @Override
    public void loadAccountList(boolean isShowProgress)
    {
        this.isShowProgress = isShowProgress;
        startAsyncTask();
    }


    private void hideProgress()
    {
        if (isShowProgress && isViewAttached()) {
            getView().hideProgress();
        }
    }

    @Override
    public void onSubscribe()
    {
        if (isViewAttached() && isShowProgress) {
            getView().showProgress();
        }
    }

    @Override
    public void onComplete()
    {
        hideProgress();
        if (isViewAttached()) {
            if (isShowProgress) {
                getView().showProgress();

            }
            getView().setAccountList(listAccounts);
        }
    }

    @Override
    public boolean doInBackground()
    {
        listAccounts = new ArrayList<>();
        try {
            listAccounts = countryRepository.getCountrySTR();

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return true;
    }

    @Override
    public void onErrorHandler(Throwable e)
    {
        hideProgress();
        if (isViewAttached()) {
            getView().showError(e.getMessage());
        }
    }

    @Override
    public void filterList(String countryFind)
    {
        try {
            if (listAccounts != null && listAccounts.size() > 0) {
                List<CountryBean> filteredList = new ArrayList<>();
                for (CountryBean accountModel : listAccounts) {

                    if (accountModel.getName().toLowerCase().contains(countryFind.toLowerCase())) {
                        filteredList.add(accountModel);
                    }
                }
                if (isViewAttached()) {
                    getView().updateAccountList(filteredList);
                }
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Override
    public void cancelSearch()
    {
        if (getView() != null) {
            getView().setClearCountry();
        }
    }

}