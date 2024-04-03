package com.example.mathapp;

public class Items {

    String name;
    String image;
    int param;

    public Items(String name, String image, int param) {
        this.name = name;
        this.image = image;
        this.param = param;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getParam() {
        return param;
    }
}
