package com.cantinho.spoonacularexample.retrofit_models.mappers;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samirtf on 18/02/17.
 */
public class VisualizeNutrientsParametersMapper {

    @SerializedName("defaultCss")
    private boolean defaultCss = true;

    @SerializedName("ingredientList")
    private List<String> ingredientList = new ArrayList<>();

    @SerializedName("servings")
    private int servings = 2;

    @SerializedName("showBacklink")
    private boolean showBacklink = true;

    public VisualizeNutrientsParametersMapper() {}

    public VisualizeNutrientsParametersMapper(boolean defaultCss, List<String> ingredientList, int servings, boolean showBacklink) {
        this.defaultCss = defaultCss;
        this.ingredientList = ingredientList;
        this.servings = servings;
        this.showBacklink = showBacklink;
    }

    public boolean isDefaultCss() {
        return defaultCss;
    }

    public void setDefaultCss(boolean defaultCss) {
        this.defaultCss = defaultCss;
    }

    public List<String> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<String> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public boolean isShowBacklink() {
        return showBacklink;
    }

    public void setShowBacklink(boolean showBacklink) {
        this.showBacklink = showBacklink;
    }

    public String getIngredientsListAsStringPerLine() {

        StringBuilder ingredientsBuilder = new StringBuilder();
        try {
            synchronized (ingredientList) {
                int ingredientsListSize = ingredientList.size();
                int i;
                for(i = 0; i < ingredientsListSize - 1; i++) {
                    ingredientsBuilder.append(ingredientList.get(i));
                    ingredientsBuilder.append(System.getProperty("line.separator"));
                }
                ingredientsBuilder.append(ingredientList.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ingredientsBuilder.toString();
    }

    @Override
    public String toString() {
        return "VisualizeNutrientsParametersMapper{" +
                "defaultCss=" + defaultCss +
                ", ingredientList=" + ingredientList +
                ", servings=" + servings +
                ", showBacklink=" + showBacklink +
                '}';
    }

}
