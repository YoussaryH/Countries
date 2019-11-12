package com.youssary.countries.app.utils;

public enum EContants
{
    ITEM_NAME("name"),
    ITEM_CAPITAL("capital"),
    ITEM_AREA("capital"),
    ITEM_COUNTRY_BEAN("country"),
    UTF_8("UTF-8"),

    ;

    private String value;

    EContants(String value)
    {
        this.value = value;
    }

    public String value()
    {
        return value;
    }
}
