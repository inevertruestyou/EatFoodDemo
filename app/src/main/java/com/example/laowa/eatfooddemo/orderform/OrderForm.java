package com.example.laowa.eatfooddemo.orderform;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.laowa.eatfooddemo.R;

import java.util.ArrayList;
import java.util.List;

public class OrderForm extends AppCompatActivity {
    private List<BoughtFood> boughtFoods = new ArrayList<>();

    private ImageView esc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_form);


        initBoughtFood();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.bought_food_recycler);
        esc = (ImageView) findViewById(R.id.esc_1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        BoughtFoodAdapter adapter =new BoughtFoodAdapter(this,boughtFoods);
        recyclerView.setAdapter(adapter);
//        getSupportActionBar().hide();



        adapter.setOnItemClickListener(new BoughtFoodAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(OrderForm.this,Evaluate.class);
                startActivity(intent);

            }
        });
        esc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        }



    private void initBoughtFood() {

            BoughtFood boughtFood1 = new BoughtFood("辣子鸡",
                    "清真餐厅",R.drawable.laj,
                    1,6.0);
            BoughtFood boughtFood2 = new BoughtFood("鱼香肉丝",
                    "龙湖餐厅",R.drawable.yxrs,
                    2,8.0);
            BoughtFood boughtFood3 = new BoughtFood("小鸡炖蘑菇",
                    "东林餐厅",R.drawable.xjdmg,
                    1,8.0);
            BoughtFood boughtFood4 = new BoughtFood("刀削面",
                    "清真餐厅",R.drawable.dxm,
                    2,8.0);
            BoughtFood boughtFood5 = new BoughtFood("白雪蹄花",
                    "浣水餐厅",R.drawable.dth,
                    4,16.0);
            BoughtFood boughtFood6 = new BoughtFood("酸辣粉",
                    "东林餐厅",R.drawable.slf,
                    5,25.0);
            BoughtFood boughtFood7 = new BoughtFood("油条",
                    "龙湖餐厅",R.drawable.yt,
                    4,4.0);
            BoughtFood boughtFood8 = new BoughtFood("担担面",
                    "浣水餐厅",R.drawable.ddm,
                    2,4.0);
            BoughtFood boughtFood9 = new BoughtFood("麻婆豆腐",
                "浣水餐厅",R.drawable.mpdf,
                2,8.0);
            BoughtFood boughtFood10 = new BoughtFood("回锅肉",
                "浣水餐厅",R.drawable.hgr,
                1,7.0);

        boughtFoods.add(boughtFood1);
        boughtFoods.add(boughtFood2);
        boughtFoods.add(boughtFood3);
        boughtFoods.add(boughtFood4);
        boughtFoods.add(boughtFood5);
        boughtFoods.add(boughtFood6);
        boughtFoods.add(boughtFood7);
        boughtFoods.add(boughtFood8);
        boughtFoods.add(boughtFood9);
        boughtFoods.add(boughtFood10);


    }
}
