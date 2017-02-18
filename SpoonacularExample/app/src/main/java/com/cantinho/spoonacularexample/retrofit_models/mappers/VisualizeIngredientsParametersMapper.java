package com.cantinho.spoonacularexample.retrofit_models.mappers;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samirtf on 18/02/17.
 */
public class VisualizeIngredientsParametersMapper {

    @SerializedName("defaultCss")
    private boolean defaultCss = true;

    @SerializedName("ingredientList")
    private List<String> ingredientList = new ArrayList<>();

    @SerializedName("measure")
    private String measure = "metric";

    @SerializedName("servings")
    private int servings = 2;

    @SerializedName("showBacklink")
    private boolean showBacklink = true;

    @SerializedName("view")
    private String view = "grid";

    public VisualizeIngredientsParametersMapper() {}

    public VisualizeIngredientsParametersMapper(boolean defaultCss, List<String> ingredientList, String measure, int servings, boolean showBacklink, String view) {
        this.defaultCss = defaultCss;
        this.ingredientList = ingredientList;
        this.measure = measure;
        this.servings = servings;
        this.showBacklink = showBacklink;
        this.view = view;
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

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
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

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    @Override
    public String toString() {
        return "VisualizeIngredientsParametersMapper{" +
                "defaultCss=" + defaultCss +
                ", ingredientList=" + ingredientList +
                ", measure='" + measure + '\'' +
                ", servings=" + servings +
                ", showBacklink=" + showBacklink +
                ", view='" + view + '\'' +
                '}';
    }

}
