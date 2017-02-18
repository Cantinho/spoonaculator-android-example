package com.cantinho.spoonacularexample.retrofit_models.mappers;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samirtf on 18/02/17.
 */
public class GroceryProductClassifierBatchMapper {

    @SerializedName("")
    private List<GroceryProductClassifierMapper> products = new ArrayList<>();

    public GroceryProductClassifierBatchMapper() {}

    public GroceryProductClassifierBatchMapper(List<GroceryProductClassifierMapper> products) {
        this.products = products;
    }

    public List<GroceryProductClassifierMapper> getProducts() {
        return products;
    }

    public void setProducts(List<GroceryProductClassifierMapper> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "GroceryProductClassifierBatchMapper{" +
                "products=" + products +
                '}';
    }

}
