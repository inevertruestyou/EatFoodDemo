package com.example.laowa.eatfooddemo.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laowa.eatfooddemo.R;

/**
 *
 * Created by 13118467271 on 2017/11/19.
 */

public class VersionActivity extends AppCompatActivity {
    private TextView textView;
    private Button back;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.version_main);
        init();
    }

    private void init() {
        textView = (TextView) findViewById(R.id.check_up_data);
        back = (Button) findViewById(R.id.back_set);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VersionActivity.this,SettingMainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(VersionActivity.this, "已经是最新版本", Toast.LENGTH_SHORT).show();
            }
        });
    }
}