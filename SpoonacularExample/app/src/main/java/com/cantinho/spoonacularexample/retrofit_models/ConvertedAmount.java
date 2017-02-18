package com.cantinho.spoonacularexample.retrofit_models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samirtf on 18/02/17.
 */
public class ConvertedAmount {

    @SerializedName("sourceAmount")
    private double sourceAmount;

    @SerializedName("sourceUnit")
    private String sourceUnit;

    @SerializedName("targetAmount")
    private double targetAmount;

    @SerializedName("targetAmount")
    private String targetUnit;

    @SerializedName("answer")
    private String answer;

    @SerializedName("type")
    private String type;

    public ConvertedAmount() {}

    public ConvertedAmount(double sourceAmount, String sourceUnit, double targetAmount,
                           String targetUnit, String answer, String type) {
        this.sourceAmount = sourceAmount;
        this.sourceUnit = sourceUnit;
        this.targetAmount = targetAmount;
        this.targetUnit = targetUnit;
        this.answer = answer;
        this.type = type;
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

    public double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public String getTargetUnit() {
        return targetUnit;
    }

    public void setTargetUnit(String targetUnit) {
        this.targetUnit = targetUnit;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ConvertedAmount{" +
                "sourceAmount=" + sourceAmount +
                ", sourceUnit='" + sourceUnit + '\'' +
                ", targetAmount=" + targetAmount +
                ", targetUnit='" + targetUnit + '\'' +
                ", answer='" + answer + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
