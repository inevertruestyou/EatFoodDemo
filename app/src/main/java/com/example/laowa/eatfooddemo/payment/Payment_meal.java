package com.example.laowa.eatfooddemo.payment;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laowa.eatfooddemo.R;
import com.example.laowa.eatfooddemo.getfoods.GetFoodActivity;

import org.w3c.dom.Text;

public class Payment_meal extends AppCompatActivity {

    private Button btn_alipay;
    private Button btn_qq;
    private Button btn_wetchat;
    private TextView foodnum;
    private TextView foodprices;
    private Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_meal_sumit);

        Intent intent = getIntent();
        String prices = intent.getStringExtra("prices");
        String foodnums = intent.getStringExtra("foodnum");

        foodnum = (TextView) findViewById(R.id.get_food_num);
        foodnum.setText("你订购了:" + foodnums);

        foodprices = (TextView) findViewById(R.id.get_food_price);
        foodprices.setText("请选择支付方式: 共计" + prices + "￥");

        btn_back = (Button) findViewById(R.id.get_food_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run() {
                        Instrumentation ins = new Instrumentation();
                        ins.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                    }
                }.start();
            }
        });


        btn_alipay = (Button) findViewById(R.id.alipay);
        btn_alipay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Payment_meal.this, "支付宝成功", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(getBaseContext(), GetFoodActivity.class);
                startActivity(intent1);
                finish();
            }
        });
        btn_qq = (Button) findViewById(R.id.qq_pay);
        btn_qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Payment_meal.this, "QQ钱包支付成功", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(getBaseContext(), GetFoodActivity.class);
                startActivity(intent2);
                finish();
            }
        });
        btn_wetchat = (Button) findViewById(R.id.weichat);
        btn_wetchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Payment_meal.this, "微信支付成功", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(getBaseContext(), GetFoodActivity.class);
                startActivity(intent3);
                finish();

            }
        });
    }
}
