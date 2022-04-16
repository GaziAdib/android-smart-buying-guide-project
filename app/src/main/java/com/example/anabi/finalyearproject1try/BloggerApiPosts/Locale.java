
package com.example.anabi.finalyearproject1try.BloggerApiPosts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Locale {

    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("variant")
    @Expose
    private String variant;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

}
