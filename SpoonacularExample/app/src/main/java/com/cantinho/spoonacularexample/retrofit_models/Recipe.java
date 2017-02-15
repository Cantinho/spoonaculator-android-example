package com.cantinho.spoonacularexample.retrofit_models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by samirtf on 14/02/17.
 */

public class Recipe {

    @SerializedName("id")
    private Integer id;

    @SerializedName("image")
    private String image;

    @SerializedName("usedIngredientCount")
    private Integer usedIngredientCount;

    @SerializedName("missedIngredientCount")
    private Integer missedIngredientCount;

    @SerializedName("likes")
    private Integer likes;

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", usedIngredientCount=" + usedIngredientCount +
                ", missedIngredientCount=" + missedIngredientCount +
                ", likes=" + likes +
                '}';
    }
}
