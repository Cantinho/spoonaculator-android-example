package com.cantinho.spoonacularexample.retrofit_models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by samirtf on 14/02/17.
 */

public class GroceryProducts {

    @SerializedName("originalString")
    private String originalString;

    @SerializedName("ingredientImage")
    private String ingredientImage;

    @SerializedName("metaInformation")
    private List<String> metaInformation;

    @SerializedName("products")
    List<Product> products;

    @Override
    public String toString() {
        return "GroceryProducts{" +
                "originalString='" + originalString + '\'' +
                ", ingredientImage='" + ingredientImage + '\'' +
                ", metaInformation='" + metaInformation + '\'' +
                ", products=" + products +
                '}';
    }
}
