package com.example.laowa.eatfooddemo.mainpageone;

import android.app.Instrumentation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.laowa.eatfooddemo.R;

public class FoodComplaintActivity extends AppCompatActivity {

    private ImageButton btn_back;
    private Button btn_ok;
    private EditText edit_complain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_complaint);
        btn_back = (ImageButton) findViewById(R.id.food_complaint_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new Thread() {
                            @Override
                            public void run() {
                                Instrumentation ins = new Instrumentation();
                                ins.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                            }
                        }.start();
                    }
                });
            }
        });
        edit_complain = (EditText) findViewById(R.id.edit_complain);
        btn_ok = (Button) findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit_complain.getText().toString().trim().equals("")) {
                    Toast.makeText(FoodComplaintActivity.this, "你什么都还没有输入呢", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(FoodComplaintActivity.this, "我们已经收到你的投诉，会尽快处理的", Toast.LENGTH_SHORT).show();
                    edit_complain.clearAnimation();
                }
            }
        });


    }
}
