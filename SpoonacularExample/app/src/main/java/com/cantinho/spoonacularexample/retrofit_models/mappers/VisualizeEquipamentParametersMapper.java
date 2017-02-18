package com.cantinho.spoonacularexample.retrofit_models.mappers;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samirtf on 18/02/17.
 */
public class VisualizeEquipamentParametersMapper {

    @SerializedName("defaultCss")
    private boolean defaultCss = true;

    @SerializedName("instructions")
    private String instructions = "";

    @SerializedName("showBackLink")
    private boolean showBackLink = true;

    @SerializedName("view")
    private String view = "grid";

    public VisualizeEquipamentParametersMapper() {}

    public VisualizeEquipamentParametersMapper(boolean defaultCss, String instructions, boolean showBackLink, String view) {
        this.defaultCss = defaultCss;
        this.instructions = instructions;
        this.showBackLink = showBackLink;
        this.view = view;
    }

    public boolean isDefaultCss() {
        return defaultCss;
    }

    public void setDefaultCss(boolean defaultCss) {
        this.defaultCss = defaultCss;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public boolean isShowBackLink() {
        return showBackLink;
    }

    public void setShowBackLink(boolean showBackLink) {
        this.showBackLink = showBackLink;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    @Override
    public String toString() {
        return "VisualizeEquipamentParametersMapper{" +
                "defaultCss=" + defaultCss +
                ", instructions='" + instructions + '\'' +
                ", showBackLink=" + showBackLink +
                ", view='" + view + '\'' +
                '}';
    }

}
