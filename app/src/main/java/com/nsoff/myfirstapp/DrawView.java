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
//���� ����������
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
        // ���û��ʵ���ɫ
        p.setColor(Color.RED);;
        canvas.drawCircle(currentX, currenty, 15, p);
    }
///Ϊ������Ĵ����¼���д�¼�������
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        currentX=event.getX();
        currenty=event.getY();
        //֪ͨ��ǰ����ػ��Լ�
        invalidate();
        //����true�������������Ѵ���÷���
        return true;
    }





}
