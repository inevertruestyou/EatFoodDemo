package com.example.laowa.eatfooddemo.setting;

import android.annotation.SuppressLint;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.laowa.eatfooddemo.R;

/**
 *
 * Created by 13118467271 on 2017/11/19.
 */

public class AccountAndSecurity extends AppCompatActivity implements View.OnClickListener {
    private Button back;
    private LinearLayout resionPassword;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_and_security);
        init();
    }

    @SuppressLint("WrongViewCast")
    private void init() {
        back = (Button) findViewById(R.id.back_myself);
        resionPassword = (LinearLayout) findViewById(R.id.revise_password);
        back.setOnClickListener(this);
        resionPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_myself:
                new Thread() {
                    @Override
                    public void run() {
                        Instrumentation ins = new Instrumentation();
                        ins.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                    }
                }.start();
                break;
            case R.id.revise_password:
                Intent intent = new Intent(AccountAndSecurity.this, RevisePasswprdActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
