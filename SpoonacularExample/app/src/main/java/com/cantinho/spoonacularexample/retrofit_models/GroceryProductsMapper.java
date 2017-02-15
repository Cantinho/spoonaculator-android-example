package com.cantinho.spoonacularexample.retrofit_models;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by samirtf on 14/02/17.
 */

public class GroceryProductsMapper {

    @SerializedName("ingredients")
    private List<String> ingredients = new LinkedList<>();

    @SerializedName("servings")
    private Integer servings = 1;

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }
}
