package com.cantinho.spoonacularexample.retrofit_models.mappers;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samirtf on 18/02/17.
 */
public class MealMapper {

    @SerializedName("diet")
    private String diet;

    @SerializedName("exclude")
    private String exclude;

    @SerializedName("targetCalories")
    private int targetCalories;

    @SerializedName("timeFrame")
    private String timeFrame;

    public MealMapper() {}

    public MealMapper(String diet, String exclude, int targetCalories, String timeFrame) {
        this.diet = diet;
        this.exclude = exclude;
        this.targetCalories = targetCalories;
        this.timeFrame = timeFrame;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getExclude() {
        return exclude;
    }

    public void setExclude(String exclude) {
        this.exclude = exclude;
    }

    public int getTargetCalories() {
        return targetCalories;
    }

    public void setTargetCalories(int targetCalories) {
        this.targetCalories = targetCalories;
    }

    public String getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(String timeFrame) {
        this.timeFrame = timeFrame;
    }

    @Override
    public String toString() {
        return "MealMapper{" +
                "diet='" + diet + '\'' +
                ", exclude='" + exclude + '\'' +
                ", targetCalories=" + targetCalories +
                ", timeFrame='" + timeFrame + '\'' +
                '}';
    }

}
