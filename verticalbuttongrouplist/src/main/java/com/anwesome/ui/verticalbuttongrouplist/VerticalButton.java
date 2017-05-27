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
    private boolean isTapped = false;
    private int color = Color.parseColor("#0097A7");
    private AnimationController touchAnimController;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public VerticalButton(Context context,String text) {
        super(context);
        this.text = text;
    }
    public void setTouchAnimController(AnimationController animController) {
        this.touchAnimController = animController;
    }
    public void onDraw(Canvas canvas) {
        int w = canvas.getWidth(),h = canvas.getHeight();
        canvas.save();
        canvas.translate(w/2,h/2);
        paint.setColor(Color.GRAY);
        float rx = Math.max(w,h)/5;
        canvas.drawRoundRect(new RectF(-w/2,-h/2,w/2,h/2),rx,rx,paint);
        canvas.save();
        canvas.scale(scale,scale);
        int r = Color.red(color),g = Color.green(color),b = Color.blue(color);
        paint.setColor(Color.argb(150,r,g,b));
        canvas.drawRoundRect(new RectF(-w/2,-h/2,w/2,h/2),rx,rx,paint);
        canvas.restore();
        canvas.restore();
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN && touchAnimController!=null && !isTapped) {
            touchAnimController.start();
            isTapped = true;
        }
        return true;
    }
    public void update(float factor) {
        scale = factor;
        postInvalidate();
    }
}
