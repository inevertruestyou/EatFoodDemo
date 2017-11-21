package com.example.laowa.eatfooddemo.matchPeoplegoto;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.laowa.eatfooddemo.R;

/**
 *
 * Created by laowa on 2017-11-13.
 */

public class MySurfaceVIew extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    int k = 0; //k用来计时
    Bitmap bmp_bg;      //背景图片
    Bitmap bmp_billboard;
    Bitmap bmp_ball;

    private SurfaceHolder sfh;
    private Paint paint;
    private int screenh, screenw;
    private Thread th;
    private Canvas canvas;
    private boolean flag;

    private MatchPeoplegoto matchPeopleProcess;


    public MySurfaceVIew(Context context, AttributeSet attrs) {
        super(context, attrs);
        sfh = this.getHolder();
        sfh.addCallback(this);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(40);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        screenh = this.getHeight();
        screenw = this.getWidth();
        flag = true;
        th = new Thread(this);
        th.start();
        matchPeopleProcess = new MatchPeoplegoto();
        bmp_bg = BitmapFactory.decodeResource(this.getResources(), R.mipmap.pic1);
        bmp_ball = BitmapFactory.decodeResource(this.getResources(), R.mipmap.theball);
    }

    public void myDraw() {
        try {
            canvas = sfh.lockCanvas();
            if (canvas != null){

                float x = (float)screenw / bmp_bg.getWidth();
                float y = (float)screenh / bmp_bg.getHeight();

                //对背景图片进行缩放
                canvas.save();
                canvas.scale(x, y, 0, 0);
                canvas.drawBitmap(bmp_bg, 0, 0, paint);
                canvas.restore();
                canvas.drawText("稍等片刻，饭友马上来哦！", 200 , 200, paint);
//                canvas.drawBitmap(bmp_billboard, screenw/2 - bmp_billboard.getWidth()/2,screenh/2 + bmp_billboard.getHeight()/2, paint);
                canvas.drawBitmap(bmp_ball, 300, 800 - k * 5, paint);

                if (k >= 0 && k < 20 ) {
                    canvas.drawText("正在匹配中.", 200, 300, paint);
                }else if (k >= 20 && k < 40) {
                    canvas.drawText("正在匹配中..", 200, 300, paint);
                }else if (k >= 40 && k < 60) {
                    canvas.drawText("正在匹配中...", 200, 300, paint);
                }else if (k >= 60 && k < 80) {
                    canvas.drawText("正在匹配中.", 200, 300, paint);
                }else if (k >= 80 && k <= 100) {
                    canvas.drawText("正在匹配中..", 200, 300, paint);
                }else {
                    canvas.drawText("正在匹配中...", 200, 300, paint);
                }


            }
        }catch (Exception e){

        }finally {
            if (canvas != null) {
                sfh.unlockCanvasAndPost(canvas);
            }
        }
    }



    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void run() {
        while (flag){
            long start = System.currentTimeMillis();
            myDraw();
            logic();
            long end = System.currentTimeMillis();
            try {
                if (end - start < 50){
                    Thread.sleep(50 - (end -start));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void logic() {
        if (k < 120) {
            k++;
        }else {
//            matchPeopleProcess.myHandler.sendEmptyMessage(1);
            k = 120;
        }
    }
}
