package com.cantinho.spoonacularexample.retrofit_models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samirtf on 18/02/17.
 */
public class Meal {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("readyInMinutes")
    private int readyInMinutes;

    @SerializedName("image")
    private String image;

    @SerializedName("imageUrls")
    private List<String> imageUrls = new ArrayList<>();

    public Meal(int id) {}

    public Meal(int id, String title, int readyInMinutes, String image, List<String> imageUrls) {
        this.id = id;
        this.title = title;
        this.readyInMinutes = readyInMinutes;
        this.image = image;
        this.imageUrls = imageUrls;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(int readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", readyInMinutes=" + readyInMinutes +
                ", image='" + image + '\'' +
                ", imageUrls=" + imageUrls +
                '}';
    }

}
