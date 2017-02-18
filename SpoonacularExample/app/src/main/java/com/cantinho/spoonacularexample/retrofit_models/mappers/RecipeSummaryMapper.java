package com.cantinho.spoonacularexample.retrofit_models.mappers;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samirtf on 18/02/17.
 */

public class RecipeSummaryMapper {

    @SerializedName("id")
    private int id;

    public RecipeSummaryMapper() {}

    public RecipeSummaryMapper(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RecipeSummaryMapper{" +
                "id=" + id +
                '}';
    }

}
