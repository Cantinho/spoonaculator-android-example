package com.cantinho.spoonacularexample.retrofit_models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by samirtf on 18/02/17.
 */
public class ClassifiedCuisine {

    @SerializedName("cuisine")
    private String cuisine;

    @SerializedName("cuisines")
    private List<String> cuisines;

    @SerializedName("confidence")
    private int confidence = 0;

    public ClassifiedCuisine() {}

    public ClassifiedCuisine(String cuisine, List<String> cuisines, int confidence) {
        this.cuisine = cuisine;
        this.cuisines = cuisines;
        this.confidence = confidence;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public List<String> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<String> cuisines) {
        this.cuisines = cuisines;
    }

    public int getConfidence() {
        return confidence;
    }

    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    @Override
    public String toString() {
        return "ClassifiedCuisine{" +
                "cuisine='" + cuisine + '\'' +
                ", cuisines=" + cuisines +
                ", confidence=" + confidence +
                '}';
    }
}
