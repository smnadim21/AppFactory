package com.smnadim21.food1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CatItem {


    @SerializedName("title")
    @Expose
    private String title;


    @SerializedName("description")
    @Expose
    private String desc;

    @SerializedName("image")
    @Expose
    private String image;


    @SerializedName("place")
    @Expose
    private String loc;


    Integer imageres;

    public CatItem(String title, String desc, String image, String loc) {
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.loc = loc;
    }

    public CatItem(String title, String desc, int image1, String loc) {
        this.title = title;
        this.desc = desc;
        this.imageres = image1;
        this.loc = loc;

    }

    public Integer getImageres() {
        return imageres;
    }

    public void setImageres(Integer imageres) {
        this.imageres = imageres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
