package com.example.laowa.eatfooddemo;

import com.example.laowa.eatfooddemo.mainpageone.FoodAdapter;
import com.example.laowa.eatfooddemo.mainpageone.MatchPeopleAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Created by Administrator on 2017-11-08.
 */


public class Constant {

    private ArrayList<MatchPeopleAdapter> peopleList = new ArrayList<>();
    //private List<String> list_schoollocal = new ArrayList<>();
    static List<String> list_schoollocal = Arrays.asList("成龙校区","东校区","狮子山校区");       //会导致list的size固定
    private List<FoodAdapter> specialFoods;
    public static String[] sichuan_normal_university = { "龙湖餐厅","东林餐厅","清真食堂","浣水食堂","云海餐厅" };

    public static String[] mItemTexts = new String[] { "小红", "小王", "小东",
            "小张", "小明", "小瓜" };

    public static int[] mItemImgs = new int[] { R.drawable.home_mbank_1_normal,
            R.drawable.home_mbank_2_normal, R.drawable.home_mbank_3_normal,
            R.drawable.home_mbank_4_normal, R.drawable.home_mbank_5_normal,
            R.drawable.home_mbank_6_normal };




}