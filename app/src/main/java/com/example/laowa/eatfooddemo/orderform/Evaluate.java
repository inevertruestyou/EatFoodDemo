package com.example.laowa.eatfooddemo.orderform;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laowa.eatfooddemo.R;


public class Evaluate extends AppCompatActivity {

    private static final int ADD_EVALUATE = 1;

    private ImageView esc;

    private EditText editText1;
    private EditText editText2;

    private TextView textView2;
    private TextView textView3;
    private TextView textView4;

    private RatingBar ratingBar1;
    private RatingBar ratingBar2;
    private RatingBar ratingBar3;
    private RatingBar ratingBar4;

    private View view1;
    private View view2;
    private View view3;

    private TextView isue;

    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case ADD_EVALUATE:
                    initVisibility();
                    break;
                default:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);
        esc = (ImageView) findViewById(R.id.esc);

        ratingBar1 = (RatingBar) findViewById(R.id.food_grace1);

        ratingBar2 = (RatingBar) findViewById(R.id.food_grace2);
        ratingBar3 = (RatingBar) findViewById(R.id.food_grace3);
        ratingBar4 = (RatingBar) findViewById(R.id.food_grace4);

        textView2 = (TextView) findViewById(R.id.food_grace22);
        textView3 = (TextView) findViewById(R.id.food_grace33);
        textView4 = (TextView) findViewById(R.id.food_grace44);

        editText1 = (EditText) findViewById(R.id.edit_text1);
        editText2 = (EditText) findViewById(R.id.edit_text2);

        view1 = (View) findViewById(R.id.view_1);
        view2 = (View) findViewById(R.id.view_2);
        view3 = (View) findViewById(R.id.view_3);

        isue = (TextView) findViewById(R.id.isue);

        ratingBar1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = ADD_EVALUATE;
                        handler.sendMessage(message);
                    }
                }).start();
            }
        });

        isue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ratingBar1.getNumStars()!=0&&editText1.length()!=0&&editText2.length()!=0) {


                    finish();
                }else {
                    Toast.makeText(getApplicationContext(),"请你认真填写后再发布", Toast.LENGTH_SHORT).show();
                }
            }
        });
         esc.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 finish();
             }
         });
    }

    private void initVisibility() {
        if (view1.getVisibility()==View.GONE){
            Log.d("AAAAAAAAA","==================");

            view1.setVisibility(View.VISIBLE);
            view2.setVisibility(View.VISIBLE);
            view3.setVisibility(View.VISIBLE);

            textView2.setVisibility(View.VISIBLE);
            textView3.setVisibility(View.VISIBLE);
            textView4.setVisibility(View.VISIBLE);

            ratingBar2.setVisibility(View.VISIBLE);
            ratingBar3.setVisibility(View.VISIBLE);
            ratingBar4.setVisibility(View.VISIBLE);

        }
    }
}
