package com.example.aroma.models;

public class Article {
    String name;
    String imageUrl;
      int priotory;
    String category;
    String hindiDesciption;
    String description;

    String hindiName;

    public String getHindiName() {
        return hindiName;
    }

    public void setHindiName(String hindiName) {
        this.hindiName = hindiName;
    }

    public String getHindiDesciption() {
        return hindiDesciption;
    }

    public void setHindiDesciption(String hindiDesciption) {
        this.hindiDesciption = hindiDesciption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Article(String name, String imageUrl, int priotory, String category) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.priotory = priotory;
        this.category = category;
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
