package com.example.laowa.eatfooddemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laowa.eatfooddemo.friendscircle.FriendsCircleActivity;
import com.example.laowa.eatfooddemo.mainpageone.FoodComplaintActivity;
import com.example.laowa.eatfooddemo.mainpageone.FoodRecyclerViewAdapter;
import com.example.laowa.eatfooddemo.mainpageone.SearchActivity;
import com.example.laowa.eatfooddemo.mainpageone.FoodAdapter;
import com.example.laowa.eatfooddemo.ordermeal.OrderMealActivity;
import com.example.laowa.eatfooddemo.shopcar.ShopCarActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.laowa.eatfooddemo.Constant.sichuan_normal_university;


/**
 * 第一个页面
 */

public class MyFragment1 extends Fragment implements AdapterView.OnItemClickListener {

    private MainActivity mainActivity;

    private TextView go_to_meal;

    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    FoodRecyclerViewAdapter adapter1;       //recyclerview适配器
    private TextView mSearch;
    private GridView gridView;
    private List<Map<String, Object>> grid_data;
    private SimpleAdapter simpleAdapter;
    private int[] icon = {R.mipmap.tab_better_normal, R.mipmap.tab_channel_normal, R.mipmap.tab_message_normal};
    private String[] iconName = {"点评", "点餐", "饭圈"};
    private List<FoodAdapter> fruitList = new ArrayList<>();
    private int meal_order = -1;     //用于记录食堂

    public MyFragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content, container, false);

        mainActivity = new MainActivity();

        Spinner spinner = (Spinner) view.findViewById(R.id.main_spinner);
        //为下拉列表定义一个适配器。
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, Constant.list_schoollocal);
        //为适配器设置下拉列表下拉时的菜单样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将适配器添加到下拉列表上
        spinner.setAdapter(adapter);
        //设置各种事件的响应
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getContext(), "你选择了" + adapter.getItem(arg2), Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        go_to_meal = (TextView) view.findViewById(R.id.go_to_meal);
        go_to_meal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getContext(), OrderMealActivity.class);
                startActivity(intent);
            }
        });


        mSearch = (TextView) view.findViewById(R.id.tv_search_bg);
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                int location[] = new int[2];
                mSearch.getLocationOnScreen(location);
                intent.putExtra("x", location[0]);
                intent.putExtra("y", location[1]);
                startActivity(intent);
//                overridePendingTransition(0,0);
            }
        });

        gridView = (GridView) view.findViewById(R.id.menu_grid_main);
        grid_data = new ArrayList<>();
        getData();
        String[] from = {"image", "text"};
        int[] to = {R.id.image, R.id.text};
        simpleAdapter = new SimpleAdapter(getContext(), grid_data, R.layout.grid_item, from, to);
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(this);

        /*
        *  recyclerview
         */
        initFood();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.main_recyclerview_specialdishes);
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter1 = new FoodRecyclerViewAdapter(fruitList);
        setLister();
        recyclerView.setAdapter(adapter1);
        return view;
    }

    private void setLister() {
        adapter1.setmOnItemClickListener(new FoodRecyclerViewAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position) {
             //   Toast.makeText(getContext(), "你点击了" + fruitList.get(position).getRastaurantid(), Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(getContext(), OrderMealActivity.class);
                intent2.putExtra("name1", sichuan_normal_university[fruitList.get(position).getRastaurantid()]);
                startActivity(intent2);
            }


        });
    }

    private void initFood() {

        FoodAdapter apple = new FoodAdapter(R.drawable.xjdmg, "小鸡炖蘑菇", (float) 1.5, "鸡肉，蘑菇，水，盐等", 1, 0);
        fruitList.add(apple);
        FoodAdapter banana = new FoodAdapter(R.drawable.yt, "油条", (float) 4.0, "面粉，食用油", 1, 0);
        fruitList.add(banana);
        FoodAdapter orange = new FoodAdapter(R.drawable.yxrs, "鱼香肉丝", (float) 2.5, "猪肉，莴笋，淀粉等", 1, 1);
        fruitList.add(orange);
        FoodAdapter watermelon = new FoodAdapter(R.drawable.laj, "辣子鸡", (float) 4.5, "鸡肉，青椒等", 1, 2);
        fruitList.add(watermelon);
        FoodAdapter pear = new FoodAdapter(R.drawable.hgr, "回锅肉", (float) 5.0, "猪肉，青椒，淀粉等", 1, 3);
        fruitList.add(pear);
        FoodAdapter grape = new FoodAdapter(R.drawable.dth, "白雪蹄花", (float) 2.0, "猪蹄，大豆等", 1, 2);
        fruitList.add(grape);
        FoodAdapter pineapple = new FoodAdapter(R.drawable.dj, "豆浆", (float) 2.5, "黄豆，水等", 1, 1);
        fruitList.add(pineapple);

    }

    //gridview适配
    public List<Map<String, Object>> getData() {
        //cion和iconName的长度是相同的，这里任选其一都可以
        for (int i = 0; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            grid_data.add(map);
        }
        return grid_data;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                Intent intent = new Intent(getContext(), FoodComplaintActivity.class);
                startActivity(intent);
                break;
            case 1:
                AlertDialog.Builder listDialog =
                        new AlertDialog.Builder(getContext());
                listDialog.setTitle("你想去哪个食堂呢？");
                listDialog.setItems(sichuan_normal_university, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.out.println("which ====================" + which);
                        meal_order = which;
                        Intent intent2 = new Intent(getContext(), OrderMealActivity.class);
                        intent2.putExtra("name1", sichuan_normal_university[meal_order]);
           //             intent2.putExtra("name1", which);
                        startActivity(intent2);
                    }
                });
                listDialog.show();
                break;
            case 2:
                Intent intent1 = new Intent(getContext(), FriendsCircleActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
