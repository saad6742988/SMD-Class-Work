package com.example.myapplication.CardViewExample;

public class My_model {
    private String name;
    private int count,thumbnail;

    public My_model(String name, int count, int thumbnail) {
        this.name = name;
        this.count = count;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
