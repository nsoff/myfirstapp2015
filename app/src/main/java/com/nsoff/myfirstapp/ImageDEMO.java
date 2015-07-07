package com.nsoff.myfirstapp;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class ImageDEMO extends ActionBarActivity {

    // ����ͼƬ�б�
    int[] images = new int[]{
            R.drawable.lijiang,
            R.drawable.qiao,
            R.drawable.shuangta,
            R.drawable.shui,
            R.drawable.xiangbi,
    };
    // ���õ�ǰ�ǵڼ���ͼƬ
    int currentImg = 2;
    // ͸���ȵ�ֵ
    private int alpha = 255;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_demo);
        final Button plus = (Button) findViewById(R.id.plus);
        final Button minus = (Button) findViewById(R.id.minus);
        final ImageView image1 = (ImageView) findViewById(R.id.image1);
        final ImageView image2 = (ImageView) findViewById(R.id.image2);
        final Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // ����ImageView��ʾ��һ��ͼƬ
                image1.setImageResource(
                        images[++currentImg % images.length]);
            }
        });
        // ����ı�ͼƬ͸���ȵķ���
        View.OnClickListener listener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (v == plus)
                {
                    alpha += 20;
                }
                if (v == minus)
                {
                    alpha -= 20;
                }
                if (alpha >= 255)
                {
                    alpha = 255;
                }
                if (alpha <= 0)
                {
                    alpha = 0;
                }
                // �ı�ͼƬ��͸����
                image1.setAlpha(alpha);
            }
        };
        // Ϊ������ť���Ӽ�����
        plus.setOnClickListener(listener);
        minus.setOnClickListener(listener);
        image1.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent event)
            {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) image1
                        .getDrawable();
                // ��ȡ��һ��ͼƬ��ʾ���е�λͼ
                Bitmap bitmap = bitmapDrawable.getBitmap();
                // bitmapͼƬʵ�ʴ�С���һ��ImageView�����ű���
                double scale = bitmap.getWidth() / 320.0;
                // ��ȡ��Ҫ��ʾ��ͼƬ�Ŀ�ʼ��
                int x = (int) (event.getX() * scale);
                int y = (int) (event.getY() * scale);
                if (x + 120 > bitmap.getWidth())
                {
                    x = bitmap.getWidth() - 120;
                }
                if (y + 120 > bitmap.getHeight())
                {
                    y = bitmap.getHeight() - 120;
                }
                // ��ʾͼƬ��ָ������
                image2.setImageBitmap(Bitmap.createBitmap(bitmap
                        , x, y, 120, 120));
                image2.setAlpha(alpha);
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_image_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}