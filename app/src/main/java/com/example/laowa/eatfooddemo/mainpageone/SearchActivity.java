package com.example.laowa.eatfooddemo.mainpageone;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Instrumentation;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laowa.eatfooddemo.R;


public class SearchActivity extends AppCompatActivity {
    private EditText edit_search;
    private TextView btn_search;
    private FrameLayout mContentFrame;
    private ImageView btn_back;
    private boolean finishing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fg_content_search);

        edit_search = (EditText) findViewById(R.id.tv_search_bg);
        mContentFrame = (FrameLayout) findViewById(R.id.frame_content_bg);
        btn_search = (TextView) findViewById(R.id.main_search);
        btn_back = (ImageView) findViewById(R.id.iv_arrow);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SearchActivity.this, "你点击了搜索", Toast.LENGTH_SHORT).show();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run() {
                        Instrumentation ins = new Instrumentation();
                        ins.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                    }
                }.start();
            }
        });

        edit_search.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                edit_search.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                performEnterAnimation();
            }
        });
    }

    private void performEnterAnimation() {
        float originY = getIntent().getIntExtra("y", 0);

        int location[] = new int[2];
        edit_search.getLocationOnScreen(location);

        final float translateY = originY - (float) location[1];

        //放到前一个页面的位置
        edit_search.setY(edit_search.getY() + translateY);
        btn_search.setY(edit_search.getY() + (edit_search.getHeight() - btn_search.getHeight()) / 2);
        float top = getResources().getDisplayMetrics().density * 20;
        final ValueAnimator translateVa = ValueAnimator.ofFloat(edit_search.getY(), top);
        translateVa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                edit_search.setY((Float) valueAnimator.getAnimatedValue());

                btn_back.setY(edit_search.getY() + (edit_search.getHeight() - btn_back.getHeight()) / 2);
                btn_search.setY(edit_search.getY() + (edit_search.getHeight() - btn_search.getHeight()) / 2);
            }
        });

        ValueAnimator scaleVa = ValueAnimator.ofFloat(1, 0.8f);
        scaleVa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                edit_search.setScaleX((Float) valueAnimator.getAnimatedValue());
            }
        });

        ValueAnimator alphaVa = ValueAnimator.ofFloat(0, 1f);
        alphaVa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mContentFrame.setAlpha((Float) valueAnimator.getAnimatedValue());
                btn_search.setAlpha((Float) valueAnimator.getAnimatedValue());
                btn_back.setAlpha((Float) valueAnimator.getAnimatedValue());
            }
        });

        alphaVa.setDuration(500);
        translateVa.setDuration(500);
        scaleVa.setDuration(500);

        alphaVa.start();
        translateVa.start();
        scaleVa.start();

    }

    @Override
    public void onBackPressed() {
        if (!finishing){
            finishing = true;
            performExitAnimation();
        }
    }

    private void performExitAnimation() {
        float originY = getIntent().getIntExtra("y", 0);

        int location[] = new int[2];
        edit_search.getLocationOnScreen(location);

        final float translateY = originY - (float) location[1];

        final ValueAnimator translateVa = ValueAnimator.ofFloat(edit_search.getY(), edit_search.getY()+translateY);
        translateVa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                edit_search.setY((Float) valueAnimator.getAnimatedValue());
                btn_back.setY(edit_search.getY() + (edit_search.getHeight() - btn_back.getHeight()) / 2);
                btn_search.setY(edit_search.getY() + (edit_search.getHeight() - btn_search.getHeight()) / 2);
            }
        });
        translateVa.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                finish();
                overridePendingTransition(0, 0);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        ValueAnimator scaleVa = ValueAnimator.ofFloat(0.8f, 1f);
        scaleVa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                edit_search.setScaleX((Float) valueAnimator.getAnimatedValue());
            }
        });

        ValueAnimator alphaVa = ValueAnimator.ofFloat(1, 0f);
        alphaVa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mContentFrame.setAlpha((Float) valueAnimator.getAnimatedValue());

                btn_back.setAlpha((Float) valueAnimator.getAnimatedValue());
                btn_search.setAlpha((Float) valueAnimator.getAnimatedValue());
            }
        });

        alphaVa.setDuration(500);
        translateVa.setDuration(500);
        scaleVa.setDuration(500);

        alphaVa.start();
        translateVa.start();
        scaleVa.start();

    }
}
