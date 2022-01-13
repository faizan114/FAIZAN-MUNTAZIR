package com.example.aroma.models;

public class Article {
    String name;
    String imageUrl;
   // int priotory;
    String category;
    public  String hindiName;
    public  String hindiDesciption;
    public  String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
        return hindiDesciption;
    }

    public void setHindiDescription(String hindiDescription) {
        this.hindiDesciption = hindiDescription;
    }

    public Article(String name, String imageUrl, int priotory, String category, String hindiName, String hindiDescription) {
        this.name = name;
        this.imageUrl = imageUrl;

        this.category = category;
        this.hindiName = hindiName;
        this.hindiDesciption = hindiDescription;
    }

    public Article() {
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }


    public String getCategory() {
        return category;
    }
}
