package com.cantinho.spoonacularexample.retrofit_models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samirtf on 18/02/17.
 */
public class ExtendedIngredient {

    @SerializedName("id")
    private int id = 0;

    @SerializedName("aisle")
    private String aisle = "Ethnic Foods";

    @SerializedName("image")
    private String image = "https://spoonacular.com/cdn/ingredients_100x100/chili-powder.jpg";

    @SerializedName("name")
    private String name = "ancho chile powder";

    @SerializedName("amount")
    private double amount = 1.5;

    @SerializedName("unit")
    private String unit = "teaspoons";

    @SerializedName("unitShort")
    private String unitShort = "t";

    @SerializedName("unitLong")
    private String unitLong = "teaspoons";

    @SerializedName("originalString")
    private String originalString = "1 1/2 teaspoons chipotle chile powder or ancho chile powder";

    @SerializedName("metaInformation")
    private List<String> metaInformation = new ArrayList<>();

    public ExtendedIngredient() {}

    public ExtendedIngredient(int id, String aisle, String image, String name, double amount,
                              String unit, String unitShort, String unitLong, String originalString,
                              List<String> metaInformation) {

        this.id = id;
        this.aisle = aisle;
        this.image = image;
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.unitShort = unitShort;
        this.unitLong = unitLong;
        this.originalString = originalString;
        this.metaInformation = metaInformation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnitShort() {
        return unitShort;
    }

    public void setUnitShort(String unitShort) {
        this.unitShort = unitShort;
    }

    public String getUnitLong() {
        return unitLong;
    }

    public void setUnitLong(String unitLong) {
        this.unitLong = unitLong;
    }

    public String getOriginalString() {
        return originalString;
    }

    public void setOriginalString(String originalString) {
        this.originalString = originalString;
    }

    public List<String> getMetaInformation() {
        return metaInformation;
    }

    public void setMetaInformation(List<String> metaInformation) {
        this.metaInformation = metaInformation;
    }

    @Override
    public String toString() {
        return "ExtendedIngredient{" +
                "id=" + id +
                ", aisle='" + aisle + '\'' +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", unit='" + unit + '\'' +
                ", unitShort='" + unitShort + '\'' +
                ", unitLong='" + unitLong + '\'' +
                ", originalString='" + originalString + '\'' +
                ", metaInformation=" + metaInformation +
                '}';
    }

}
