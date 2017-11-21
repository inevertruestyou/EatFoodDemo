package com.example.laowa.eatfooddemo.ordermeal.bean;

import java.util.List;

/**
 *
 * Created by Administrator on 2017/11/3.
 */

public class CategoryBag {
    Category category;
    boolean isSelected;

    public CategoryBag(Category category, boolean isSelected) {
        this.category = category;
        this.isSelected = isSelected;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getSortName() {
        return this.category.getSortName();
    }

    public List<food> getFoodList(){
        return this.category.getFoodList();
    }

    public void setSeleted(boolean seleted) {
        this.isSelected = seleted;
    }
}
