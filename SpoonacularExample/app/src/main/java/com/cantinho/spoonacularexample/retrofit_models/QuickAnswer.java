package com.cantinho.spoonacularexample.retrofit_models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samirtf on 18/02/17.
 */
public class QuickAnswer {

    @SerializedName("answer")
    private String answer;

    @SerializedName("image")
    private String image;

    @SerializedName("type")
    private String type;

    public QuickAnswer() {}

    public QuickAnswer(String answer, String image, String type) {
        this.answer = answer;
        this.image = image;
        this.type = type;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "QuickAnswer{" +
                "answer='" + answer + '\'' +
                ", image='" + image + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
