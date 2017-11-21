package com.example.laowa.eatfooddemo.resgister;

import android.app.Instrumentation;
import android.app.ProgressDialog;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.laowa.eatfooddemo.R;
import com.example.laowa.eatfooddemo.mainpageone.LoginActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResgisterActivity extends AppCompatActivity {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    Button btn_back;
    private EditText etEmail;
    private EditText etPassword;
    private String inputEmail,inputPassword;
    Button register_user;
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        btn_back = (Button) findViewById(R.id.back_login);
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

        etEmail = (EditText) findViewById(R.id.e_mail);

      // inputPassword = tlPassword.getEditText().getText().toString();
        register_user = (Button) findViewById(R.id.register);
        register_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputEmail = etEmail.getEditableText().toString();
                System.out.println("inputemail==============" + inputEmail);
                verifyEmail();
            }
        });
    }


    public void verifyEmail() {
        if (!validateEmail(inputEmail)){
            Toast.makeText(this,"请输入正确的邮箱地址",Toast.LENGTH_SHORT).show();
      //  }else if (!validatePassword(inputPassword)){
        //    tlPassword.setErrorEnabled(true);
        //    Toast.makeText(LoginActivity.this,"密码字数过少",Toast.LENGTH_SHORT).show();
        }else{

        }
    }

    private boolean validateEmail(String loginEmail){
        Matcher matcher = pattern.matcher(loginEmail);
        return matcher.matches();
    }
}
