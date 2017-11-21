package com.example.laowa.eatfooddemo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laowa.eatfooddemo.activity.PersonShowActivity;
import com.example.laowa.eatfooddemo.myfriends.MyFriendsActivity;
import com.example.laowa.eatfooddemo.orderform.OrderForm;
import com.example.laowa.eatfooddemo.setting.SettingMainActivity;

import static com.example.laowa.eatfooddemo.R.id.myself_intent_person;

/*
 *
 * Created by Administrator on 2017-10-28.
 */

public class MyFragment4 extends Fragment {
    private RelativeLayout myselfPersonMessage;
    private RelativeLayout myselfOrder;
    private RelativeLayout myselfFriend;
    private RelativeLayout myselfSetup;


    private ImageView myselfHeadImage;
    private TextView myselfName;
    private TextView myselfPersonalized;
    private Button myselfIntentPerson;
    SharedPreferences preferences;
    private String name;   //用来存储邮箱
    private String personalizedSignature;
    public MyFragment4(){

    }
    @SuppressLint("ValidFragment")
    public MyFragment4(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myself_activity, container, false);
        name = preferences.getString("name", "");
        personalizedSignature = preferences.getString("personalizedSignature", "");
        init(view);
        return view;
    }

    private void init(View view) {
        myselfPersonMessage = (RelativeLayout) view.findViewById(R.id.myself_person_message);
        myselfOrder = (RelativeLayout) view.findViewById(R.id.myself_order_relative);
        myselfFriend = (RelativeLayout) view.findViewById(R.id.myself_friend_revative);
        myselfSetup = (RelativeLayout) view.findViewById(R.id.myself_setup_relative);
        myselfHeadImage = (ImageView) view.findViewById(R.id.myself_head_image);
        myselfName = (TextView) view.findViewById(R.id.myself_name);
        myselfName.setText(name);
        myselfPersonalized = (TextView) view.findViewById(R.id.myself_personalized_signature);
        myselfPersonalized.setText(personalizedSignature);
        myselfIntentPerson = (Button) view.findViewById(myself_intent_person);

        myselfPersonMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(), "message", Toast.LENGTH_SHORT).show();
                Intent myselfIntentPerson = new Intent(getContext(), PersonShowActivity.class);
                startActivity(myselfIntentPerson);
            }
        });
        myselfOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), OrderForm.class);
                startActivity(intent);
            }
        });
        myselfFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(), "friend", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), MyFriendsActivity.class);
                startActivity(intent);
            }
        });
        myselfSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_setting = new Intent(getContext(), SettingMainActivity.class);
                startActivity(intent_setting);
            }
        });
        myselfHeadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        myselfName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        myselfPersonalized.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        myselfPersonMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myselfIntentPerson = new Intent(getContext(), PersonShowActivity.class);
                startActivity(myselfIntentPerson);
            }
        });
    }
}
