package com.example.laowa.eatfooddemo.ordermeal.bean;

/**
 *
 * Created by Administrator on 2016/3/18.
 */
public class food {
    private String name;
    private int ImagePath;
    private String special;
    private double Price;


    public food(String name, int imagePath, String special, double price) {
        this.name = name;
        ImagePath = imagePath;
        this.special = special;
        Price = price;

    }



    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }


    public int getImagePath() {
        return ImagePath;
    }

    public void setImagePath(int imagePath) {
        ImagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
