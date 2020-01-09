package com.reshika.foodmandu.model;

public class Detail {

    public String name;
    public String location;
    public String image;
    public String item;

    public Detail(String name, String location, String image, String item) {
        this.name = name;
        this.location = location;
        this.image = image;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
