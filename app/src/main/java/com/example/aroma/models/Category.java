package com.example.aroma.models;

public class Category {
    public  String name;
    public  String imageUrl;
    public  String priotory;
    public  String hindiName;

    public String getHindiName() {
        return hindiName;
    }

    public void setHindiName(String hindiName) {
        this.hindiName = hindiName;
    }

    public Category() {
    }

    public Category(String name, String imageUrl, String priotory) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.priotory = priotory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPriotory() {
        return priotory;
    }

    public void setPriotory(String priotory) {
        this.priotory = priotory;
    }
}

