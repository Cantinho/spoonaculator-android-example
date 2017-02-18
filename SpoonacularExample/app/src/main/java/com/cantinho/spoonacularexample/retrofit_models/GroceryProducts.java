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

    public GroceryProducts(String originalString) {}

    public GroceryProducts(String originalString, String ingredientImage, List<String> metaInformation, List<Product> products) {
        this.originalString = originalString;
        this.ingredientImage = ingredientImage;
        this.metaInformation = metaInformation;
        this.products = products;
    }

    public String getOriginalString() {
        return originalString;
    }

    public void setOriginalString(String originalString) {
        this.originalString = originalString;
    }

    public String getIngredientImage() {
        return ingredientImage;
    }

    public void setIngredientImage(String ingredientImage) {
        this.ingredientImage = ingredientImage;
    }

    public List<String> getMetaInformation() {
        return metaInformation;
    }

    public void setMetaInformation(List<String> metaInformation) {
        this.metaInformation = metaInformation;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

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
