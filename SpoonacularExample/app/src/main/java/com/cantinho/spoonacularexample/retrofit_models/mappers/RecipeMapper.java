package com.cantinho.spoonacularexample.retrofit_models.mappers;

import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.util.List;

/**
 * Created by samirtf on 18/02/17.
 */
public class RecipeMapper {

    public static final String ELLIPSE_MASK = "ellipseMask";
    public static final String DIAMOND_MASK = "diamondMask";
    public static final String STAR_MASK = "starMask";
    public static final String HEART_MASK = "heartMask";
    public static final String POT_MASK = "potMask";
    public static final String FISH_MASK = "fishMask";

    @SerializedName("author")
    private String author;

    @SerializedName("backgroundColor")
    private String backgroundColor;

    @SerializedName("backgroundImage")
    private String backgroundImage;

    @SerializedName("fontColor")
    private String fontColor;

    @SerializedName("image")
    private File image;

    @SerializedName("ingredients")
    private List<String> ingredients;

    @SerializedName("instructions")
    private List<String> instructions;

    @SerializedName("mask")
    private String mask;

    @SerializedName("readyInMinutes")
    private int readyInMinutes;

    @SerializedName("servings")
    private int servings;

    @SerializedName("source")
    private String source;

    @SerializedName("title")
    private String title;

    public RecipeMapper() {}

    public RecipeMapper(String author, String backgroundColor, String backgroundImage,
                        String fontColor, File image, List<String> ingredients,
                        List<String> instructions, String mask, int readyInMinutes,
                        int servings, String source, String title) {

        this.author = author;
        this.backgroundColor = backgroundColor;
        this.backgroundImage = backgroundImage;
        this.fontColor = fontColor;
        this.image = image;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.mask = mask;
        this.readyInMinutes = readyInMinutes;
        this.servings = servings;
        this.source = source;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(int readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredientsAsStringPerLine() {
        StringBuilder ingredientsPerLineBuilder = new StringBuilder();
        try {
            synchronized (ingredients) {
                final int ingredientsListSize = ingredients.size();
                int i;
                for (i = 0; i < ingredientsListSize - 1; i++) {
                    ingredientsPerLineBuilder.append(ingredients.get(i));
                    ingredientsPerLineBuilder.append(System.getProperty("line.separator"));
                }
                ingredientsPerLineBuilder.append(ingredients.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ingredientsPerLineBuilder.toString();
    }

    public String getInstructionsAsStringPerLine() {
        StringBuilder instructionsPerLineBuilder = new StringBuilder();
        try {
            synchronized (instructions) {
                final int instructionsListSize = instructions.size();
                int i;
                for (i = 0; i < instructionsListSize - 1; i++) {
                    instructionsPerLineBuilder.append(instructions.get(i));
                    instructionsPerLineBuilder.append(System.getProperty("line.separator"));
                }
                instructionsPerLineBuilder.append(instructions.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instructionsPerLineBuilder.toString();
    }

    @Override
    public String toString() {
        return "RecipeMapper{" +
                "author='" + author + '\'' +
                ", backgroundColor='" + backgroundColor + '\'' +
                ", backgroundImage='" + backgroundImage + '\'' +
                ", fontColor='" + fontColor + '\'' +
                ", image=" + image +
                ", ingredients=" + ingredients +
                ", instructions=" + instructions +
                ", mask='" + mask + '\'' +
                ", readyInMinutes=" + readyInMinutes +
                ", servings=" + servings +
                ", source='" + source + '\'' +
                ", title='" + title + '\'' +
                '}';
    }


}
