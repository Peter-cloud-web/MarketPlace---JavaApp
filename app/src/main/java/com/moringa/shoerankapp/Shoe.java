package com.moringa.shoerankapp;

import android.media.Image;

public class Shoe {
    private String name;
    private int price;
    private String description;
    private int thumbnail;

    public Shoe(String name, int price, String description, int thumbnail) {
        this.name = name;
        this.price = price;
        this.description = description;
       this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getThumbnail() {
        return thumbnail;
    }
}
