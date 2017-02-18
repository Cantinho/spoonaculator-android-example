package com.cantinho.spoonacularexample.retrofit_models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by samirtf on 18/02/17.
 */
public class RecipeInformation {


    @SerializedName("vegeratian")
    private boolean vegetarian = false;

    @SerializedName("vegan")
    private boolean vegan = false;

    @SerializedName("glutenFree")
    private boolean glutenFree = true;

    @SerializedName("dairyFree")
    private boolean dairyFree = true;

    @SerializedName("veryHealthy")
    private boolean veryHealthy = false;

    @SerializedName("cheap")
    private boolean cheap = false;

    @SerializedName("veryPopular")
    private boolean veryPopular = false;

    @SerializedName("sustainable")
    private boolean sustainable = false;

    @SerializedName("weightWatcherSmartPoints")
    private int weightWatcherSmartPoints = 21;

    @SerializedName("gaps")
    private String gaps = "no";

    @SerializedName("lowFodmap")
    private boolean lowFodmap = false;

    @SerializedName("ketogenic")
    private boolean ketogenic = false;

    @SerializedName("whole30")
    private boolean whole30 = false;

    @SerializedName("servings")
    private int servings = 10;

    @SerializedName("sourceUrl")
    private String sourceUrl = "http://www.epicurious.com/recipes/food/views/Char-Grilled-Beef-Tenderloin-with-Three-Herb-Chimichurri-235342";

    @SerializedName("spoonacularSourceUrl")
    private String spoonacularSourceUrl = "https://spoonacular.com/char-grilled-beef-tenderloin-with-three-herb-chimichurri-156992";

    @SerializedName("aggregateLikes")
    private int aggregateLikes = 0;

    @SerializedName("creditText")
    private String creditText = "Epicurious";

    @SerializedName("sourceName")
    private String sourceName = "Epicurious";

    @SerializedName("extendedIngredients")
    private List<ExtendedIngredient> extendedIngredients;

    @SerializedName("id")
    private int id = 0;

    @SerializedName("title")
    private String title = "Char-Grilled Beef Tenderloin with Three-Herb Chimichurri";

    @SerializedName("readyInMinutes")
    private int readyInMinutes = 45;

    @SerializedName("image")
    private String image = "https://spoonacular.com/recipeImages/char-grilled-beef-tenderloin-with-three-herb-chimichurri-156992.jpg";

    @SerializedName("imageType")
    private String imageType = "jpg";

    @SerializedName("instructions")
    private String instructions = "PreparationFor spice rub:";

    public RecipeInformation() {}

    public RecipeInformation(boolean vegetarian, boolean vegan, boolean glutenFree,
                             boolean dairyFree, boolean veryHealthy, boolean cheap,
                             boolean veryPopular, boolean sustainable, int weightWatcherSmartPoints,
                             String gaps, boolean lowFodmap, boolean ketogenic, boolean whole30,
                             int servings, String sourceUrl, String spoonacularSourceUrl,
                             int aggregateLikes, String creditText, String sourceName,
                             List<ExtendedIngredient> extendedIngredients, int id, String title,
                             int readyInMinutes, String image, String imageType, String instructions) {

        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.glutenFree = glutenFree;
        this.dairyFree = dairyFree;
        this.veryHealthy = veryHealthy;
        this.cheap = cheap;
        this.veryPopular = veryPopular;
        this.sustainable = sustainable;
        this.weightWatcherSmartPoints = weightWatcherSmartPoints;
        this.gaps = gaps;
        this.lowFodmap = lowFodmap;
        this.ketogenic = ketogenic;
        this.whole30 = whole30;
        this.servings = servings;
        this.sourceUrl = sourceUrl;
        this.spoonacularSourceUrl = spoonacularSourceUrl;
        this.aggregateLikes = aggregateLikes;
        this.creditText = creditText;
        this.sourceName = sourceName;
        this.extendedIngredients = extendedIngredients;
        this.id = id;
        this.title = title;
        this.readyInMinutes = readyInMinutes;
        this.image = image;
        this.imageType = imageType;
        this.instructions = instructions;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public boolean isDairyFree() {
        return dairyFree;
    }

    public void setDairyFree(boolean dairyFree) {
        this.dairyFree = dairyFree;
    }

    public boolean isVeryHealthy() {
        return veryHealthy;
    }

    public void setVeryHealthy(boolean veryHealthy) {
        this.veryHealthy = veryHealthy;
    }

    public boolean isCheap() {
        return cheap;
    }

    public void setCheap(boolean cheap) {
        this.cheap = cheap;
    }

    public boolean isVeryPopular() {
        return veryPopular;
    }

    public void setVeryPopular(boolean veryPopular) {
        this.veryPopular = veryPopular;
    }

    public boolean isSustainable() {
        return sustainable;
    }

    public void setSustainable(boolean sustainable) {
        this.sustainable = sustainable;
    }

    public int getWeightWatcherSmartPoints() {
        return weightWatcherSmartPoints;
    }

    public void setWeightWatcherSmartPoints(int weightWatcherSmartPoints) {
        this.weightWatcherSmartPoints = weightWatcherSmartPoints;
    }

    public String getGaps() {
        return gaps;
    }

    public void setGaps(String gaps) {
        this.gaps = gaps;
    }

    public boolean isLowFodmap() {
        return lowFodmap;
    }

    public void setLowFodmap(boolean lowFodmap) {
        this.lowFodmap = lowFodmap;
    }

    public boolean isKetogenic() {
        return ketogenic;
    }

    public void setKetogenic(boolean ketogenic) {
        this.ketogenic = ketogenic;
    }

    public boolean isWhole30() {
        return whole30;
    }

    public void setWhole30(boolean whole30) {
        this.whole30 = whole30;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getSpoonacularSourceUrl() {
        return spoonacularSourceUrl;
    }

    public void setSpoonacularSourceUrl(String spoonacularSourceUrl) {
        this.spoonacularSourceUrl = spoonacularSourceUrl;
    }

    public int getAggregateLikes() {
        return aggregateLikes;
    }

    public void setAggregateLikes(int aggregateLikes) {
        this.aggregateLikes = aggregateLikes;
    }

    public String getCreditText() {
        return creditText;
    }

    public void setCreditText(String creditText) {
        this.creditText = creditText;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public List<ExtendedIngredient> getExtendedIngredients() {
        return extendedIngredients;
    }

    public void setExtendedIngredients(List<ExtendedIngredient> extendedIngredients) {
        this.extendedIngredients = extendedIngredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(int readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "RecipeInformation{" +
                "vegetarian=" + vegetarian +
                ", vegan=" + vegan +
                ", glutenFree=" + glutenFree +
                ", dairyFree=" + dairyFree +
                ", veryHealthy=" + veryHealthy +
                ", cheap=" + cheap +
                ", veryPopular=" + veryPopular +
                ", sustainable=" + sustainable +
                ", weightWatcherSmartPoints=" + weightWatcherSmartPoints +
                ", gaps='" + gaps + '\'' +
                ", lowFodmap=" + lowFodmap +
                ", ketogenic=" + ketogenic +
                ", whole30=" + whole30 +
                ", servings=" + servings +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", spoonacularSourceUrl='" + spoonacularSourceUrl + '\'' +
                ", aggregateLikes=" + aggregateLikes +
                ", creditText='" + creditText + '\'' +
                ", sourceName='" + sourceName + '\'' +
                ", extendedIngredients=" + extendedIngredients +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", readyInMinutes=" + readyInMinutes +
                ", image='" + image + '\'' +
                ", imageType='" + imageType + '\'' +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}
