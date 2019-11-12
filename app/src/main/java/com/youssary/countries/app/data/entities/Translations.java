package com.youssary.countries.app.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Translations implements Parcelable
{
    @SerializedName("de")
    @Expose
    private String de;
    @SerializedName("es")
    @Expose
    private String es;
    @SerializedName("fr")
    @Expose
    private String fr;
    @SerializedName("ja")
    @Expose
    private String ja;
    @SerializedName("it")
    @Expose
    private String it;
    @SerializedName("br")
    @Expose
    private String br;
    @SerializedName("pt")
    @Expose
    private String pt;
    @SerializedName("nl")
    @Expose
    private String nl;
    @SerializedName("hr")
    @Expose
    private String hr;
    @SerializedName("fa")
    @Expose
    private String fa;

    public String getDe()
    {
        return de;
    }

    public void setDe(String de)
    {
        this.de = de;
    }

    public String getEs()
    {
        return es;
    }

    public void setEs(String es)
    {
        this.es = es;
    }

    public String getFr()
    {
        return fr;
    }

    public void setFr(String fr)
    {
        this.fr = fr;
    }

    public String getJa()
    {
        return ja;
    }

    public void setJa(String ja)
    {
        this.ja = ja;
    }

    public String getIt()
    {
        return it;
    }

    public void setIt(String it)
    {
        this.it = it;
    }

    public String getBr()
    {
        return br;
    }

    public void setBr(String br)
    {
        this.br = br;
    }

    public String getPt()
    {
        return pt;
    }

    public void setPt(String pt)
    {
        this.pt = pt;
    }

    public String getNl()
    {
        return nl;
    }

    public void setNl(String nl)
    {
        this.nl = nl;
    }

    public String getHr()
    {
        return hr;
    }

    public void setHr(String hr)
    {
        this.hr = hr;
    }

    public String getFa()
    {
        return fa;
    }

    public void setFa(String fa)
    {
        this.fa = fa;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(this.de);
        dest.writeString(this.es);
        dest.writeString(this.fr);
        dest.writeString(this.ja);
        dest.writeString(this.it);
        dest.writeString(this.br);
        dest.writeString(this.pt);
        dest.writeString(this.nl);
        dest.writeString(this.hr);
        dest.writeString(this.fa);
    }

    public Translations()
    {
    }

    protected Translations(Parcel in)
    {
        this.de = in.readString();
        this.es = in.readString();
        this.fr = in.readString();
        this.ja = in.readString();
        this.it = in.readString();
        this.br = in.readString();
        this.pt = in.readString();
        this.nl = in.readString();
        this.hr = in.readString();
        this.fa = in.readString();
    }

    public static final Creator<Translations> CREATOR = new Creator<Translations>()
    {
        @Override
        public Translations createFromParcel(Parcel source)
        {
            return new Translations(source);
        }

        @Override
        public Translations[] newArray(int size)
        {
            return new Translations[size];
        }
    };
}
