package com.cantinho.spoonacularexample.retrofit_models.mappers;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samirtf on 18/02/17.
 */
public class QuestioMapper {

    @SerializedName("q")
    private String q;

    public QuestioMapper() {}

    public QuestioMapper(String q) {
        this.q = q;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    @Override
    public String toString() {
        return "QuestioMapper{" +
                "q='" + q + '\'' +
                '}';
    }


}