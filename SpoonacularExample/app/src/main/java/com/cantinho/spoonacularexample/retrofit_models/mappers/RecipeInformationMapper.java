package com.cantinho.spoonacularexample.retrofit_models.mappers;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samirtf on 18/02/17.
 */
public class RecipeInformationMapper {

    @SerializedName("id")
    private int id;

    @SerializedName("includeNutrition")
    private boolean includeNutrition;

    public RecipeInformationMapper() {}

    public RecipeInformationMapper(int id, boolean includeNutrition) {
        this.id = id;
        this.includeNutrition = includeNutrition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIncludeNutrition() {
        return includeNutrition;
    }

    public void setIncludeNutrition(boolean includeNutrition) {
        this.includeNutrition = includeNutrition;
    }

    @Override
    public String toString() {
        return "RecipeInformationMapper{" +
                "id=" + id +
                ", includeNutrition=" + includeNutrition +
                '}';
    }

}
