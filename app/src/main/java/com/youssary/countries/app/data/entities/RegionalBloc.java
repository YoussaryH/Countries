package com.youssary.countries.app.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RegionalBloc implements Parcelable
{

    @SerializedName("acronym")
    @Expose
    private String acronym;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("otherAcronyms")
    @Expose
    private List<Object> otherAcronyms = new ArrayList<Object>();
    @SerializedName("otherNames")
    @Expose
    private List<Object> otherNames = new ArrayList<Object>();

    public String getAcronym()
    {
        return acronym;
    }

    public void setAcronym(String acronym)
    {
        this.acronym = acronym;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Object> getOtherAcronyms()
    {
        return otherAcronyms;
    }

    public void setOtherAcronyms(List<Object> otherAcronyms)
    {
        this.otherAcronyms = otherAcronyms;
    }

    public List<Object> getOtherNames()
    {
        return otherNames;
    }

    public void setOtherNames(List<Object> otherNames)
    {
        this.otherNames = otherNames;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(this.acronym);
        dest.writeString(this.name);
        dest.writeList(this.otherAcronyms);
        dest.writeList(this.otherNames);
    }

    public RegionalBloc()
    {
    }

    protected RegionalBloc(Parcel in)
    {
        this.acronym = in.readString();
        this.name = in.readString();
        this.otherAcronyms = new ArrayList<Object>();
        in.readList(this.otherAcronyms, Object.class.getClassLoader());
        this.otherNames = new ArrayList<Object>();
        in.readList(this.otherNames, Object.class.getClassLoader());
    }

    public static final Creator<RegionalBloc> CREATOR = new Creator<RegionalBloc>()
    {
        @Override
        public RegionalBloc createFromParcel(Parcel source)
        {
            return new RegionalBloc(source);
        }

        @Override
        public RegionalBloc[] newArray(int size)
        {
            return new RegionalBloc[size];
        }
    };
}
