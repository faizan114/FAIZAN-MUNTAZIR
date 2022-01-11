package com.example.aroma.models;

public class Article {
    String name;
    String imageUrl;
    int priotory;
    String category;
    public  String hindiName;
    public  String hindiDescription;



    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPriotory(int priotory) {
        this.priotory = priotory;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHindiName() {
        return hindiName;
    }

    public void setHindiName(String hindiName) {
        this.hindiName = hindiName;
    }

    public String getHindiDescription() {
        return hindiDescription;
    }

    public void setHindiDescription(String hindiDescription) {
        this.hindiDescription = hindiDescription;
    }

    public Article(String name, String imageUrl, int priotory, String category, String hindiName, String hindiDescription) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.priotory = priotory;
        this.category = category;
        this.hindiName = hindiName;
        this.hindiDescription = hindiDescription;
    }

    public Article() {
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getPriotory() {
        return priotory;
    }

    public String getCategory() {
        return category;
    }
}
