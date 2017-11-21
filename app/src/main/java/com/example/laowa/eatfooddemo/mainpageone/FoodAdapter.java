package com.example.laowa.eatfooddemo.mainpageone;

/**
 *
 * Created by Administrator on 2017-10-27.
 */

public class FoodAdapter {
    private int food_imageId;
    private String food_name;
    private Float food_num;
    private int picid;
    private String food_all;
    private int rastaurantid;

    public FoodAdapter(int food_imageId, String food_name, Float food_num, String food_all, int picid, int rastaurantid) {
        this.food_name = food_name;
        this.food_num = food_num;
        this.food_imageId = food_imageId;
        this.picid = picid;
        this.food_all = food_all;
        this.rastaurantid = rastaurantid;           //食堂代号0， 1， 2， 3 代表不同的食堂
    }

    public String getFood_all() {
        return food_all;
    }

    public void setFood_all(String food_all) {
        this.food_all = food_all;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public int getPicid() {
        return picid;
    }

    public void setPicid(int picid) {
        this.picid = picid;
    }

    public Float getFood_num() {
        return food_num;
    }

    public void setFood_num(Float food_num) {
        this.food_num = food_num;
    }


    public int getFood_imageId() {
        return food_imageId;
    }

    public void setFood_imageId(int food_imageId) {
        this.food_imageId = food_imageId;
    }

    public int getRastaurantid() {
        return rastaurantid;
    }

    public void setRastaurantid(int rastaurantid) {
        this.rastaurantid = rastaurantid;
    }
}
