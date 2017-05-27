package com.anwesome.ui.verticalbuttongrouplist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 27/05/17.
 */

public class VerticalButton extends View {
    private float scale = 0;
    private String text;
    private int color = Color.parseColor("#0097A7");
    private AnimationController touchAnimController;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public VerticalButton(Context context,String text,AnimationController animationController) {
        super(context);
        this.text = text;
        this.touchAnimController = animationController;
    }
    public void onDraw(Canvas canvas) {
        int w = canvas.getWidth(),h = canvas.getHeight();
        canvas.save();
        canvas.translate(w/2,h/2);
        paint.setColor(Color.GRAY);
        canvas.drawRoundRect(new RectF(-w/2,-h/2,w/2,h/2),Math.max(w,h)/10,Math.max(w,h)/10,paint);
        canvas.save();
        canvas.scale(scale,scale);
        int r = Color.red(color),g = Color.green(color),b = Color.blue(color);
        paint.setColor(Color.argb(150,r,g,b));
        canvas.drawRoundRect(new RectF(-w/2,-h/2,w/2,h/2),Math.max(w,h)/10,Math.max(w,h)/10,paint);
        canvas.restore();
        canvas.restore();
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN && touchAnimController!=null) {

        }
        return true;
    }
    public void update(float factor) {
        scale = factor;
        postInvalidate();
    }
}
