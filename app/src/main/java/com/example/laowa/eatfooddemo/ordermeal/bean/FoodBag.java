package com.example.laowa.eatfooddemo.ordermeal.bean;

/**
 *
 * Created by Administrator on 2017/11/3.
 */

public class FoodBag {
    com.example.laowa.eatfooddemo.ordermeal.bean.food food;
    int willSellNumber;
    int allFoodNumber;
    public FoodBag(com.example.laowa.eatfooddemo.ordermeal.bean.food food) {
        this.food = food;
        this.willSellNumber = 0;
        allFoodNumber = 0;

    }


    private int getAllFoodNumber(){
        allFoodNumber = willSellNumber;
        return allFoodNumber;

    }

    public void clickAdd() {
        ++this.willSellNumber;
    }

    public boolean clickSub() {
        if (willSellNumber == 0) {
            return false;
        } else {
            --willSellNumber;
            return true;
        }
    }

    public boolean isShow() {
        return true;
    }

    public int getWillSellNumber() {
        return this.willSellNumber;
    }

    public int getImagePath() {
        return this.food.getImagePath();
    }



    public String getName() {
        return this.food.getName();
    }
    public double getPrice() {
        return this.food.getPrice();
    }
    public String getSpecial() {
        return this.food.getSpecial();
    }
}
