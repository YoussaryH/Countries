package com.youssary.countries.app.utils;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;




public class SampleGlideModule extends AppGlideModule
{
    @Override
    public boolean isManifestParsingEnabled()
    {
        return false;

    }


}
