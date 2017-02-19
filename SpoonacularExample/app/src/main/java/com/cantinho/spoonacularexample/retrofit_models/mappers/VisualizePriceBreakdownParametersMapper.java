package com.cantinho.spoonacularexample.retrofit_models.mappers;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samirtf on 18/02/17.
 */
public class VisualizePriceBreakdownParametersMapper {


    @SerializedName("defaultCss")
    private boolean defaultCss = true;

    @SerializedName("ingredientList")
    private List<String> ingredientList = new ArrayList<>();

    @SerializedName("mode")
    private int mode = 1;

    @SerializedName("servings")
    private int servings = 2;

    @SerializedName("showBacklink")
    private boolean showBacklink = true;

    public VisualizePriceBreakdownParametersMapper() {}

    public VisualizePriceBreakdownParametersMapper(boolean defaultCss, List<String> ingredientList,
                                                   int mode, int servings, boolean showBacklink) {
        this.defaultCss = defaultCss;
        this.ingredientList = ingredientList;
        this.mode = mode;
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

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
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
        return "VisualizePriceBreakdownParametersMapper{" +
                "defaultCss=" + defaultCss +
                ", ingredientList=" + ingredientList +
                ", mode=" + mode +
                ", servings=" + servings +
                ", showBacklink=" + showBacklink +
                '}';
    }

}
