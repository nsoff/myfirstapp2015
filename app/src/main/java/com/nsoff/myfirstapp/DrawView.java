package com.nsoff.myfirstapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


/**
 * TODO: document your custom view class.
 */
public class DrawView extends View {

    public float currentX=40;
    public float currenty=50;
//定义 并创建画笔
    Paint p=new Paint();

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // TODO: consider storing these as member variables to reduce
        // 设置画笔的颜色
        p.setColor(Color.RED);;
        canvas.drawCircle(currentX, currenty, 15, p);
    }
///为该组件的触碰事件重写事件处理方法
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        currentX=event.getX();
        currenty=event.getY();
        //通知当前组件重绘自己
        invalidate();
        //返回true表明方处理方法已处理该方法
        return true;
    }





}
