package com.example.laowa.eatfooddemo.setting;

import android.annotation.SuppressLint;
import android.app.Instrumentation;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.laowa.eatfooddemo.R;

/**
 *
 * Created by 13118467271 on 2017/11/19.
 */

public class RevisePasswprdActivity extends AppCompatActivity {
    private EditText editText;
    private Button setNewPassword;
    private Button getback;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.revise_password_activity);
        init();
    }

    @SuppressLint("WrongViewCast")
    private void init() {
        editText = (EditText) findViewById(R.id.revise_password);
        setNewPassword = (Button) findViewById(R.id.set_new_password);
        setNewPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        getback = (Button) findViewById(R.id.back_account_and_security);
        getback.setOnClickListener(new View.OnClickListener() {
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
}
