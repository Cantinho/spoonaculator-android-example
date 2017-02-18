package com.cantinho.spoonacularexample.retrofit_models.mappers;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samirtf on 18/02/17.
 */
public class GroceryProductClassifierMapper {

    @SerializedName("title")
    private String title = "";

    @SerializedName("upc")
    private String upc = "";

    @SerializedName("plu_code")
    private String plu_code = "";

    public GroceryProductClassifierMapper(String title) {}

    public GroceryProductClassifierMapper(String title, String upc, String plu_code) {
        this.title = title;
        this.upc = upc;
        this.plu_code = plu_code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getPlu_code() {
        return plu_code;
    }

    public void setPlu_code(String plu_code) {
        this.plu_code = plu_code;
    }

    @Override
    public String toString() {
        return "GroceryProductClassifierMapper{" +
                "title='" + title + '\'' +
                ", upc='" + upc + '\'' +
                ", plu_code='" + plu_code + '\'' +
                '}';
    }
}
