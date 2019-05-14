package com.smartdroidesign.volleyrecyclerview.model;

public class Item {
    private String imageUrls;
    private String author;
    private int likes;

    public Item(String imageUrls, String author, int likes) {
        this.imageUrls = imageUrls;
        this.author = author;
        this.likes = likes;
    }

    public String getImageUrls() {
        return imageUrls;
    }

    public String getAuthor() {
        return author;
    }

    public int getLikes() {
        return likes;
    }
}
