package com.cantinho.spoonacularexample.retrofit_models.mappers;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samirtf on 18/02/17.
 */
public class AmountMapper {

    @SerializedName("ingredientName")
    private String ingredientName;

    @SerializedName("sourceAmount")
    private double sourceAmount;

    @SerializedName("sourceUnit")
    private String sourceUnit;

    @SerializedName("targetUnit")
    private String targetUnit;

    public AmountMapper() {}

    public AmountMapper(String ingredientName, double sourceAmount, String sourceUnit, String targetUnit) {
        this.ingredientName = ingredientName;
        this.sourceAmount = sourceAmount;
        this.sourceUnit = sourceUnit;
        this.targetUnit = targetUnit;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public double getSourceAmount() {
        return sourceAmount;
    }

    public void setSourceAmount(double sourceAmount) {
        this.sourceAmount = sourceAmount;
    }

    public String getSourceUnit() {
        return sourceUnit;
    }

    public void setSourceUnit(String sourceUnit) {
        this.sourceUnit = sourceUnit;
    }

    public String getTargetUnit() {
        return targetUnit;
    }

    public void setTargetUnit(String targetUnit) {
        this.targetUnit = targetUnit;
    }

    @Override
    public String toString() {
        return "AmountMapper{" +
                "ingredientName='" + ingredientName + '\'' +
                ", sourceAmount=" + sourceAmount +
                ", sourceUnit='" + sourceUnit + '\'' +
                ", targetUnit='" + targetUnit + '\'' +
                '}';
    }

}
