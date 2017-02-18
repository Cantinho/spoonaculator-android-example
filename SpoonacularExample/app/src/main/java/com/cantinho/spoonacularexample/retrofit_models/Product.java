package com.cantinho.spoonacularexample.retrofit_models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samirtf on 14/02/17.
 */
public class Product {

    @SerializedName("id")
    private Integer id;

    @SerializedName("upc")
    private String upc;

    @SerializedName("title")
    private String title;

    public Product() {}

    public Product(Integer id, String upc, String title) {
        this.id = id;
        this.upc = upc;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", upc='" + upc + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
