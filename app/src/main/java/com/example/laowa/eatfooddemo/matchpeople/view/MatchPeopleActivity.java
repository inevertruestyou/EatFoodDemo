package com.example.laowa.eatfooddemo.matchpeople.view;

import android.annotation.SuppressLint;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laowa.eatfooddemo.MainActivity;
import com.example.laowa.eatfooddemo.MyFragment2;
import com.example.laowa.eatfooddemo.R;
import com.example.laowa.eatfooddemo.chatrom.ChatRoom;
import com.example.laowa.eatfooddemo.matchPeoplegoto.MatchPeoplegoto;

public class MatchPeopleActivity extends AppCompatActivity {
    AttributeSet attrs;
    private View btn_back;
    private TextView message;
    private CircleMenuLayout circleMenuLayout;
    private String string;

        @SuppressLint("HandlerLeak")
        Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
     //               gototext();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    private void gototext() {

        Runnable mRunnable = new Runnable() {
            @Override
            public void run() {
                Intent intent1 = new Intent(MatchPeopleActivity.this, ChatRoom.class);
                startActivity(intent1);
            }
        };
        Thread mThread= new Thread(mRunnable);
        mThread.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_people_activity);
        message = (TextView) findViewById(R.id.match_people_message);
    //    circleMenuLayout = new CircleMenuLayout(this, attrs, message);
        btn_back = findViewById(R.id.back_match_people);
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

        message.setText("来一次冒险吧");
    }

}
