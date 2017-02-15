package com.cantinho.spoonacularexample.retrofit_models;

/**
 * Created by samirtf on 14/02/17.
 */
public class Product {

    private Integer id;
    private String upc;
    private String title;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", upc='" + upc + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
