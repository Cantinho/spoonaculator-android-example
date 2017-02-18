package com.cantinho.spoonacularexample.models;

/**
 * Created by samirtf on 14/02/17.
 */

class Card {
    private Integer code = -1;
    private String title = "";
    private String subtitle = "";

    public Card(Integer code, String title, String subtitle) {
        this.code = code;
        this.title = title;
        this.subtitle = subtitle;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @Override
    public String toString() {
        return "Card{" +
                "code=" + code +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                '}';
    }
}