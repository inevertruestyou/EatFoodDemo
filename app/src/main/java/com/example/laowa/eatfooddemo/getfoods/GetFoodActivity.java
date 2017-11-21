package com.example.laowa.eatfooddemo.getfoods;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.laowa.eatfooddemo.MainActivity;
import com.example.laowa.eatfooddemo.R;

public class GetFoodActivity extends AppCompatActivity {

    ImageButton btn_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getfood_activity);
        btn_back = (ImageButton) findViewById(R.id.food_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
