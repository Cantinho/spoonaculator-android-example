package com.cantinho.spoonacularexample.retrofit_models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samirtf on 18/02/17.
 */
public class ClassifiedProduct {

    @SerializedName("breadcrumbs")
    private List<String> breadcrumbs = new ArrayList<>();

    @SerializedName("category")
    private String category;

    @SerializedName("cleanTitle")
    private String cleanTitle;

    @SerializedName("usaCode")
    private int usdaCode = 0;

    public ClassifiedProduct(List<String> breadcrumbs) {}

    public ClassifiedProduct(List<String> breadcrumbs, String category, String cleanTitle, int usdaCode) {
        this.breadcrumbs = breadcrumbs;
        this.category = category;
        this.cleanTitle = cleanTitle;
        this.usdaCode = usdaCode;
    }

    public List<String> getBreadcrumbs() {
        return breadcrumbs;
    }

    public void setBreadcrumbs(List<String> breadcrumbs) {
        this.breadcrumbs = breadcrumbs;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCleanTitle() {
        return cleanTitle;
    }

    public void setCleanTitle(String cleanTitle) {
        this.cleanTitle = cleanTitle;
    }

    public int getUsdaCode() {
        return usdaCode;
    }

    public void setUsdaCode(int usdaCode) {
        this.usdaCode = usdaCode;
    }

    @Override
    public String toString() {
        return "ClassifiedProduct{" +
                "breadcrumbs=" + breadcrumbs +
                ", category='" + category + '\'' +
                ", cleanTitle='" + cleanTitle + '\'' +
                ", usdaCode=" + usdaCode +
                '}';
    }
}
