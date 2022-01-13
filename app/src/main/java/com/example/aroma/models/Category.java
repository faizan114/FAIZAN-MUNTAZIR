package com.example.aroma.models;

public class Category {
    public  String name;
    public  String imageUrl;
//    public  String priotory;
    public  String hindiName;

    public String getHindiName() {
        return hindiName;
    }

    public void setHindiName(String hindiName) {
        this.hindiName = hindiName;
    }

    public Category() {
    }

    public Category(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;

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



}

