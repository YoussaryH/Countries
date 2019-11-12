package com.youssary.countries.app.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class CountryBean implements Parcelable
{

    private String name;
    private String nativeName;
    private String region;
    private String capital;
    private Double area;

    private Translations translations;
    private List<Language> languages = new ArrayList<Language>();



    private String languagesSTR = "";
    private String languagesComp = "";
    private String translationsDE;
    private String flag;

    private List<Double> latlng = new ArrayList<Double>();


    private List<RegionalBloc> regionalBlocs = new ArrayList<RegionalBloc>();


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


    public String getCapital()
    {
        return capital;
    }

    public void setCapital(String capital)
    {
        this.capital = capital;
    }


    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    public List<Double> getLatlng()
    {
        return latlng;
    }

    public void setLatlng(List<Double> latlng)
    {
        this.latlng = latlng;
    }

    public Double getArea()
    {
        return area;
    }

    public void setArea(Double area)
    {
        this.area = area;
    }

    public String getNativeName()
    {
        return nativeName;
    }

    public void setNativeName(String nativeName)
    {
        this.nativeName = nativeName;
    }

    public List<Language> getLanguages()
    {
        return languages;
    }

    public void setLanguages(List<Language> languages)
    {
        this.languages = languages;
    }

    public Translations getTranslations()
    {
        return translations;
    }

    public void setTranslations(Translations translations)
    {
        this.translations = translations;
    }

    public String getFlag()
    {
        return flag;
    }

    public void setFlag(String flag)
    {
        this.flag = flag;
    }

    public List<RegionalBloc> getRegionalBlocs()
    {
        return regionalBlocs;
    }

    public void setRegionalBlocs(List<RegionalBloc> regionalBlocs)
    {
        this.regionalBlocs = regionalBlocs;
    }

    public String getLanguagesSTR()
    {
        int i=1;
        languagesSTR = "";
        for (Language list : languages) {
            if (list.getName() != null) {
                if(languages.size()!=i){
                    languagesSTR += list.getName() + ", ";
                    i++;
                }else{
                    languagesSTR += list.getName();
                }


            }
        }
        return languagesSTR;
    }
    public void setLanguagesSTR(String languagesSTR)
    {
        this.languagesSTR = languagesSTR;
    }

    public String getTranslationsDE()
    {
        translationsDE = translations.getDe();
        return translationsDE;
    }


    public String getLanguagesComp()
    {
        return languagesComp;
    }

    public void setLanguagesComp(String languagesComp)
    {
        this.languagesComp = languagesComp;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(this.name);
        dest.writeString(this.nativeName);
        dest.writeString(this.region);
        dest.writeString(this.capital);
        dest.writeValue(this.area);
        dest.writeParcelable(this.translations, flags);
        dest.writeList(this.languages);
        dest.writeString(this.languagesSTR);
        dest.writeString(this.languagesComp);
        dest.writeString(this.translationsDE);
        dest.writeString(this.flag);
        dest.writeList(this.latlng);
        dest.writeList(this.regionalBlocs);
    }

    public CountryBean()
    {
    }

    protected CountryBean(Parcel in)
    {
        this.name = in.readString();
        this.nativeName = in.readString();
        this.region = in.readString();
        this.capital = in.readString();
        this.area = (Double) in.readValue(Double.class.getClassLoader());
        this.translations = in.readParcelable(Translations.class.getClassLoader());
        this.languages = new ArrayList<Language>();
        in.readList(this.languages, Language.class.getClassLoader());
        this.languagesSTR = in.readString();
        this.languagesComp = in.readString();
        this.translationsDE = in.readString();
        this.flag = in.readString();
        this.latlng = new ArrayList<Double>();
        in.readList(this.latlng, Double.class.getClassLoader());
        this.regionalBlocs = new ArrayList<RegionalBloc>();
        in.readList(this.regionalBlocs, RegionalBloc.class.getClassLoader());
    }

    public static final Creator<CountryBean> CREATOR = new Creator<CountryBean>()
    {
        @Override
        public CountryBean createFromParcel(Parcel source)
        {
            return new CountryBean(source);
        }

        @Override
        public CountryBean[] newArray(int size)
        {
            return new CountryBean[size];
        }
    };
}
