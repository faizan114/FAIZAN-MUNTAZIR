package com.example.aroma.models;

public class Article {
    String name;
    String imageUrl;
    int priotory;
    String category;

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
