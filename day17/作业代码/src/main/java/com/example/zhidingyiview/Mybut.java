package com.example.zhidingyiview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

@SuppressLint("AppCompatCustomView")
public class Mybut extends Button {

    protected float Dowx;
    protected float Dowy;

    public Mybut(Context context) {
        super(context);
    }

    public Mybut(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Mybut(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Dowx = event.getX();
                Dowy = event.getY();

                break;
            case MotionEvent.ACTION_MOVE:
                float movex = event.getX();
                float movey = event.getY();
                float vx = movex - Dowx;
                float vy = movey - Dowy;
                float x = getX();
                float y = getY();
                setTranslationX(vx + x);
                setTranslationY(vy + y);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
    public float getLastX(){
        return getX();
    }
    public float getLastY(){
        return getY();
    }
}
