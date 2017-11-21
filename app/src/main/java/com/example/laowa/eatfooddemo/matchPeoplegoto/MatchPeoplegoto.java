package com.example.laowa.eatfooddemo.matchPeoplegoto;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.laowa.eatfooddemo.R;
import com.example.laowa.eatfooddemo.mainpageone.LoginActivity;
import com.example.laowa.eatfooddemo.matchpeople.view.MatchPeopleActivity;

public class MatchPeoplegoto extends AppCompatActivity {

//    @SuppressLint("HandlerLeak")
//    Handler myHandler = new Handler() {
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case 1:
//                    gotothematchpeople();
//                    break;
//            }
//            super.handleMessage(msg);
//        }
//    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_poeple_process);
        ThreadInit();

    }
    //需要重新开线程
    private void ThreadInit() {
        Runnable mRunnable = new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                Intent intent =new Intent(MatchPeoplegoto.this,MatchPeopleActivity.class);
                startActivity(intent);
                finish();
            }
        };
        Thread mThread= new Thread(mRunnable);
        mThread.start();
    }

}
