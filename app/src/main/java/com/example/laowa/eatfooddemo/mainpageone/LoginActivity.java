package com.example.laowa.eatfooddemo.mainpageone;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.laowa.eatfooddemo.MainActivity;
import com.example.laowa.eatfooddemo.R;
import com.example.laowa.eatfooddemo.resgister.ResgisterActivity;
import com.example.laowa.eatfooddemo.setting.RevisePasswprdActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Created by Administrator on 2017/9/18.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Button btLogin;
    private Button btRegister;
    private Button btFindPassword;
    private Button btClose;

    private ProgressDialog progressDialog;
    private String result = null;
    //private ParkUser user;
    private TextInputLayout tlEmail;
    private TextInputLayout tlPassword;
    private EditText etEmail;
    private EditText etPassword;
    private String inputEmail,inputPassword;
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private boolean validateEmail(String loginEmail){
       Matcher matcher = pattern.matcher(loginEmail);
       return matcher.matches();
    }
    private boolean validatePassword(String password){
        return password.length() > 5;
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            if (msg.what == 0){
                //Log.d("result" ,result);
                if (result == null){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            progressDialog.dismiss();
                        }
                    }).start();
                    Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                } else if (result.equals("error")){
                    Log.d("error", result);
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                }else{
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    Intent intentMainActivity = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intentMainActivity);
                    finish();
                }
            }
        }
    };
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login_activity);
        SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
        editor.putString("email","123456@163.com");
        editor.putString("password","123456");
        editor.putString("name","小堂堂");
        editor.putString("sex","boy");
        editor.putString("birthday","1999-11-11");
        editor.putString("local","四川成都市");
        editor.putString("school","四川师范大学");
        editor.putString("college","物理与电子工程学院");
        editor.putString("major","电子信息工程");
        editor.putString("schoolID","2015000001");
        editor.putString("enrollmentYear","2015.9");
        editor.putString("personalizedSignature","喜欢每一天");
        editor.putString("hobby","编程");
        editor.putInt("follow",6);
        editor.putInt("fans",6);
        editor.putInt("evaluate",7);
        editor.putString("constellation","天蝎座");
        editor.apply();
        init();
    }
    //初始化
    private void init() {
        tlEmail = (TextInputLayout) findViewById(R.id.tl_login_mail);
        tlPassword = (TextInputLayout) findViewById(R.id.tl_login_password);
        etEmail = (EditText) findViewById(R.id.et_login_mail);
        etEmail.setText("123456@163.com");
        etPassword = (EditText) findViewById(R.id.et_login_password);
        etPassword.setText("123456");
        btClose = (Button) findViewById(R.id.close_login);
        btFindPassword = (Button) findViewById(R.id.find_password);
        btRegister = (Button) findViewById(R.id.intent_register);
        btLogin = (Button) findViewById(R.id.bt_login);
        btLogin.setOnClickListener(this);
        btRegister.setOnClickListener(this);
        btFindPassword.setOnClickListener(this);
        btClose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:
               // Toast.makeText(LoginActivity.this,"点击登录",Toast.LENGTH_SHORT).show();
                inputEmail = tlEmail.getEditText().getText().toString();
                inputPassword = tlPassword.getEditText().getText().toString();
                login();
                break;
            case R.id.close_login:
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
                break;
            case R.id.find_password:
                Intent intent3 = new Intent(this, RevisePasswprdActivity.class);
                startActivity(intent3);
                break;
            case R.id.intent_register:
                Intent intent2 = new Intent(this, ResgisterActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }

    public void login() {

        verifyEmail();
    }

    public void verifyEmail() {
        if (!validateEmail(inputEmail)){
            Toast.makeText(LoginActivity.this,"请输入正确的邮箱地址",Toast.LENGTH_SHORT).show();
        }else if (!validatePassword(inputPassword)){
            tlPassword.setErrorEnabled(true);
            Toast.makeText(LoginActivity.this,"密码字数过少",Toast.LENGTH_SHORT).show();
        }else{
            tlEmail.setErrorEnabled(false);
            tlPassword.setErrorEnabled(false);
            progressDialog = new ProgressDialog(LoginActivity.this);
            progressDialog.setTitle("等待连接...");
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);
            progressDialog.show();
            checkUser(inputEmail, inputPassword);
        }
    }

    private void checkUser(String inputEmail, String inputPassword) {
        SharedPreferences preferences = getSharedPreferences("data",MODE_PRIVATE);
        String perEmail = preferences.getString("email","");
        String prePassword = preferences.getString("password","");
        Log.d("name=======",preferences.getString("name",""));
        if (inputEmail.equals(perEmail) ) {
            if (inputPassword.equals(prePassword)){
               result="true";
            }
        }else {
            result = "error";
        }
        Message message = new Message();
        message.what = 0;
        handler.sendMessage(message);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }




//    private void checkUser(final String email, final String password) {
//        new Thread(new Runnable() {
//
//
//            @Override
//            public void run() {
//                // HttpURLConnection connection = null;
//                String url = "http://cf9ef4ea.ngrok.io/login";
//                String request = "user_email=" + email + "&user_password=" + password;
//                NetUtil netUtil = new NetUtil();
//                result = netUtil.upInfo(url, "", request, "utf-8");
//                parseJSONWithGSON(result);
//                Message message = new Message();
//                message.what = 0;
//                handler.sendMessage(message);
//
//
//            }
//        }).start();
//

//    }
//    public void parseJSONWithGSON(String jsonData){
//        Gson gson = new Gson();
//        user = gson.fromJson(jsonData,ParkUser.class);
//
//        SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
//        editor.putString("name",user.getUserName());
//        editor.putString("school",user.getSchool());
//        editor.putString("password",user.getPassword());
//        editor.putString("email",user.getEmail());
//        editor.commit();
//    }
}
