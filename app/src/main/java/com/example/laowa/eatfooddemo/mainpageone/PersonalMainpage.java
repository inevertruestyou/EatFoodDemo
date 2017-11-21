package com.example.laowa.eatfooddemo.mainpageone;

import android.app.Instrumentation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
//import android.widget.Toast;

import com.example.laowa.eatfooddemo.R;

public class PersonalMainpage extends AppCompatActivity {

    private RelativeLayout relativeLayout_personal_show_evaluate;

    private Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_homepage);

        relativeLayout_personal_show_evaluate = (RelativeLayout) findViewById(R.id.personal_show_evaluate);
        relativeLayout_personal_show_evaluate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_back = (Button) findViewById(R.id.personal_show_back_myself);
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

    }
}
