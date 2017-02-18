package com.cantinho.spoonacularexample.retrofit_models.mappers;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samirtf on 18/02/17.
 */
public class CuisineClassifierMapper {

    /**
     * The ingredient list of the recipe, one ingredient per line.
     */
    @SerializedName("ingredientList")
    private String ingredientList;

    /**
     * The title of the recipe.
     */
    @SerializedName("title")
    private String title;

    public CuisineClassifierMapper() {}

    public CuisineClassifierMapper(String ingredientList, String title) {
        this.ingredientList = ingredientList;
        this.title = title;
    }

    public String getIngredientListAsString() {
        return ingredientList;
    }

    public void setIngredientList(String ingredientList) {
        this.ingredientList = ingredientList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CuisineClassifierMapper{" +
                "ingredientList='" + ingredientList + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

}
