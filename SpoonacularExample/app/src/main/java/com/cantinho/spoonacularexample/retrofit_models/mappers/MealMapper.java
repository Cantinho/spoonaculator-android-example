package com.cantinho.spoonacularexample.retrofit_models.mappers;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by samirtf on 18/02/17.
 */
public class MealMapper {

    @SerializedName("diet")
    private String diet;

    @SerializedName("exclude")
    private List<String> exclude;

    @SerializedName("targetCalories")
    private int targetCalories;

    @SerializedName("timeFrame")
    private String timeFrame;

    public MealMapper() {}

    public MealMapper(String diet, List<String> exclude, int targetCalories, String timeFrame) {
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

    public List<String> getExclude() {
        return exclude;
    }

    public void setExclude(List<String> exclude) {
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

    public String getExcludeListAsString(final String separator) {
        final String currentSeparator = separator == null || separator.trim().isEmpty() ? "," : separator;
        StringBuilder excludeListAsStringBuilder = new StringBuilder();
        try {
            synchronized (exclude) {
                final int excludeListSize = exclude.size();
                int i;
                for (i = 0; i < excludeListSize - 1; i++) {
                    excludeListAsStringBuilder.append(exclude.get(i));
                    excludeListAsStringBuilder.append(currentSeparator);
                }
                excludeListAsStringBuilder.append(exclude.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return excludeListAsStringBuilder.toString();
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
