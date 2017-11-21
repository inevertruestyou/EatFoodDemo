package com.example.laowa.eatfooddemo.orderform;

/**
 * Created by Lenovo Users on 2017/11/14.
 */

public class BoughtFood {
    private String boughtFoodName;
    private String boughtFoodDining;
    private int boughtFoodImagePath;
    private int boughtFoodNumber;
    private double boughtFoodAllPrice;



    public BoughtFood(String boughtFoodName,String boughtFoodDining, int boughtFoodImagePath,
                      int boughtFoodNumber,double boughtFoodAllPrice) {
        this.boughtFoodName = boughtFoodName;
        this.boughtFoodImagePath = boughtFoodImagePath;
        this.boughtFoodNumber = boughtFoodNumber;
        this.boughtFoodAllPrice = boughtFoodAllPrice;
        this.boughtFoodDining = boughtFoodDining;


    }


    public String getBoughtFoodName() {
        return boughtFoodName;
    }

    public void setBoughtFoodName(String boughtFoodName) {
        this.boughtFoodName = boughtFoodName;
    }

    public int getBoughtFoodImagePath() {
        return boughtFoodImagePath;
    }

    public void setBoughtFoodImagePath(int boughtFoodImagePath) {
        this.boughtFoodImagePath = boughtFoodImagePath;
    }

    public int getBoughtFoodNumber() {
        return boughtFoodNumber;
    }

    public void setBoughtFoodNumber(int boughtFoodNumber) {
        this.boughtFoodNumber = boughtFoodNumber;
    }



    public String getBoughtFoodDining() {
        return boughtFoodDining;
    }

    public void setBoughtFoodDining(String boughtFoodDining) {
        this.boughtFoodDining = boughtFoodDining;
    }

    public double getBoughtFoodAllPrice() {
        return boughtFoodAllPrice;
    }

    public void setBoughtFoodAllPrice(double boughtFoodAllPrice) {
        this.boughtFoodAllPrice = boughtFoodAllPrice;
    }
}
