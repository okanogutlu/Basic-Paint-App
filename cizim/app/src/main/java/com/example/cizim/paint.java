package com.example.cizim;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.annotation.Nullable;

public class paint extends View {
     static Paint paint=new Paint();
    Path path=new Path();

    public paint(Context c){
        super(c);
        paint.setColor(Color.BLACK);
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }

    public static void changeColor(int color) {

        paint.setColor(color);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path,paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x=event.getX();
        float y=event.getY();
        path.addCircle(x,y,10,Path.Direction.CW);
        invalidate();
        return true;
    }
}
