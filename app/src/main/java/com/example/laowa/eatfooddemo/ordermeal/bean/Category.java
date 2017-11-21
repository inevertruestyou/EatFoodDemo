package com.example.laowa.eatfooddemo.ordermeal.bean;

import java.util.List;

/**
 *
 * Created by Administrator on 2016/3/17.
 */
public class Category {
    private String foodKind;
    private List<food> foodList;

    public Category(String sortName, List<food> foodList) {
        this.foodKind = sortName;
        this.foodList = foodList;
    }

    public String getSortName() {
        return foodKind;
    }

    public void setSortName(String sortName) {
        this.foodKind = sortName;
    }

    public List<food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<food> foodList) {
        this.foodList = foodList;
    }
}
