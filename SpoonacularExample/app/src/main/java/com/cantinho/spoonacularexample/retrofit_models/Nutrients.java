package com.cantinho.spoonacularexample.retrofit_models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samirtf on 18/02/17.
 */
public class Nutrients {

    @SerializedName("calories")
    private int calories;

    @SerializedName("protein")
    private double protein;

    @SerializedName("fat")
    private double fat;

    @SerializedName("carbohydrates")
    private double carbohydrates;

    public Nutrients() {}

    public Nutrients(int calories, double protein, double fat, double carbohydrates) {
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @Override
    public String toString() {
        return "Nutrients{" +
                "calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", carbohydrates=" + carbohydrates +
                '}';
    }

}
