package com.cantinho.spoonacularexample.retrofit_models.mappers;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samirtf on 18/02/17.
 */
public class DailyCaloriesMapper {

    @SerializedName("targetCalories")
    private int targetCalories;

    @SerializedName("timeFrame")
    private String timeFrame;

    public DailyCaloriesMapper() {}

    public DailyCaloriesMapper(int targetCalories, String timeFrame) {
        this.targetCalories = targetCalories;
        this.timeFrame = timeFrame;
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
        return "DailyCaloriesMapper{" +
                "targetCalories=" + targetCalories +
                ", timeFrame='" + timeFrame + '\'' +
                '}';
    }

}
