package com.example.laowa.eatfooddemo.setting;

import android.annotation.SuppressLint;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.laowa.eatfooddemo.R;
import com.example.laowa.eatfooddemo.mainpageone.LoginActivity;

public class SettingMainActivity extends AppCompatActivity {

    Button btn_back;
    TextView btn_user_all;
    TextView btn_user_safe;
    TextView btn_user_version;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_setting);
        btn_back = (Button) findViewById(R.id.setting_back_up);
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

        btn_user_all = (TextView) findViewById(R.id.user_all);
        btn_user_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getBaseContext(), RevisePasswprdActivity.class);
                startActivity(intent1);
            }
        });
        btn_user_safe = (TextView) findViewById(R.id.user_safe);
        btn_user_safe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getBaseContext(), AccountAndSecurity.class);
                startActivity(intent2);
            }
        });

        btn_back = (Button) findViewById(R.id.log_out);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_user_version = (TextView) findViewById(R.id.user_version);
//        btn_user_version.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent3 = new Intent(getBaseContext(), VersionActivity.class);
//                startActivity(intent3);
//            }
//        });
    }
}
