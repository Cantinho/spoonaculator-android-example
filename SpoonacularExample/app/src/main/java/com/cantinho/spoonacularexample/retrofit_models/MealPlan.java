package com.cantinho.spoonacularexample.retrofit_models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samirtf on 18/02/17.
 */
public class MealPlan {

    @SerializedName("meals")
    private List<Meal> meals = new ArrayList<>();

    public MealPlan() {}

    public MealPlan(List<Meal> meals) {
        this.meals = meals;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    @Override
    public String toString() {
        return "MealPlan{" +
                "meals=" + meals +
                '}';
    }

}
