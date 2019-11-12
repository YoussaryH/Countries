package com.youssary.countries.country.view.MVP;

import com.youssary.countries.app.data.entities.CountryBean;

import java.util.ArrayList;
import java.util.List;

public interface CountryActivityMVP
{
    interface View
    {
        void showProgress();

        void hideProgress();

        void setAccountList(List<CountryBean> list);

        void updateAccountList(List<CountryBean> list);

        void showError(String error);

        void setClearCountry();

    }

    interface Presenter
    {
        void loadAccountList(boolean isShowProgress);

        void filterList(String countryFind);

        void cancelSearch();

    }

    interface Model
    {
        CountryBean findUser(String name);

        ArrayList<CountryBean> findUserSTR();
    }

}
