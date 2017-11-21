package com.example.laowa.eatfooddemo.activity;

import android.app.Instrumentation;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.laowa.eatfooddemo.R;

/**
 *
 * Created by Administrator on 2017/11/1.
 */

public class PersonShowActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout showAllMessage;
    private RelativeLayout showFollow;
    private RelativeLayout showFans;
    private RelativeLayout showEvaluate;
    private RelativeLayout showEditDate;

    private ImageView showHeadImage;
    private TextView showName;
    private TextView showPersonalizedSignature;//个性签名
    private TextView showSix;
    private TextView showConstellation;//星座
    private TextView showEntranceTime;

    private TextView showFollowNumber;
    private TextView showFansNumber;
    private TextView showEvaluateNumber;

    private TextView showSchool;
    private TextView showClass;
    private TextView showMajor;
    private TextView editDate;
    SharedPreferences preferences;
    private Button back;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.personal_show_activity);
        preferences = getSharedPreferences("data",MODE_PRIVATE);
        init();//初始化各个控件
    }

    private void init() {
        showAllMessage = (RelativeLayout) findViewById(R.id.personal_show_allmessage);
        showFollow = (RelativeLayout) findViewById(R.id.personal_show_follow);
        showFans = (RelativeLayout) findViewById(R.id.personal_show_fans);
        showEvaluate = (RelativeLayout) findViewById(R.id.personal_show_evaluate);
        showEditDate = (RelativeLayout) findViewById(R.id.personal_show_edit_data);

        showHeadImage = (ImageView) findViewById(R.id.personal_show_head_image);
        showName = (TextView) findViewById(R.id.personal_show_name);
        showPersonalizedSignature = (TextView) findViewById(R.id.personal_show_personalized_signature);//个性签名
        showPersonalizedSignature.setText("" + preferences.getString("personalizedSignature", ""));
        showSix = (TextView) findViewById(R.id.personal_show_six);
        showSix.setText("" + preferences.getString("sex", ""));
        showConstellation = (TextView) findViewById(R.id.personal_show_constellation);//星座
        showConstellation.setText("" + preferences.getString("constellation", ""));
        showEntranceTime = (TextView) findViewById(R.id.personal_show_entrance_time);
        showEntranceTime.setText("" + preferences.getString("enrollmentYear", ""));

        showFollowNumber = (TextView) findViewById(R.id.personal_show_follow_number);
        showFollowNumber.setText("" + preferences.getInt("follow", 0));
        showFansNumber = (TextView) findViewById(R.id.personal_show_fans_number);
        showFansNumber.setText("" + preferences.getInt("fans", 0));
        showEvaluateNumber = (TextView) findViewById(R.id.personal_show_evaluate_number);
        showEvaluateNumber.setText("" + preferences.getInt("evaluate", 0));

        showSchool = (TextView) findViewById(R.id.personal_show_school);
        showSchool.setText("" + preferences.getString("school", ""));
        showClass = (TextView) findViewById(R.id.personal_show_class);
        showClass.setText("" + preferences.getString("college", ""));
        showMajor = (TextView) findViewById(R.id.personal_show_major);
        showMajor.setText("" + preferences.getString("major", ""));
        editDate = (TextView) findViewById(R.id.personal_show_edit);
        back = (Button) findViewById(R.id.personal_show_back_myself);

        back.setOnClickListener(this);
        showAllMessage.setOnClickListener(this);
        showFollow.setOnClickListener(this);
        showFans.setOnClickListener(this);
        showEvaluate.setOnClickListener(this);
        showEditDate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.personal_show_allmessage:
            case R.id.personal_show_edit_data:
                Intent personalShowIntentEdit = new Intent(PersonShowActivity.this,PersonMessageActivity.class);
                startActivity(personalShowIntentEdit);
                finish();
                break;
            case R.id.personal_show_follow:
                Intent followIntentFollowActivity = new Intent(PersonShowActivity.this,FollowActivity.class);
                startActivity(followIntentFollowActivity);
                finish();
                break;
            case R.id.personal_show_fans:
                Intent fansIntentFanActivity = new Intent(PersonShowActivity.this,FansActivity.class);
                startActivity(fansIntentFanActivity);
                finish();
                break;
            case R.id.personal_show_evaluate:

                break;
            case R.id.personal_show_back_myself:
                new Thread(){
                    @Override
                    public void run() {
                        Instrumentation ins = new Instrumentation();
                        ins.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                    }
                }.start();
            default:
                break;
        }
    }


}
