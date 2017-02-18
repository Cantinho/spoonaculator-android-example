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

    @SerializedName("nutrients")
    private Nutrients nutrients;

    public MealPlan() {}

    public MealPlan(List<Meal> meals, Nutrients nutrients) {
        this.meals = meals;
        this.nutrients = nutrients;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public Nutrients getNutrients() {
        return nutrients;
    }

    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }

    @Override
    public String toString() {
        return "MealPlan{" +
                "meals=" + meals +
                ", nutrients=" + nutrients +
                '}';
    }

}
