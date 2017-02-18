package com.cantinho.spoonacularexample.retrofit_models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samirtf on 18/02/17.
 */
public class RecipeSummary {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("summary")
    private String summary;

    public RecipeSummary() {}

    public RecipeSummary(int id, String title, String summary) {
        this.id = id;
        this.title = title;
        this.summary = summary;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "RecipeSummary{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }

}
