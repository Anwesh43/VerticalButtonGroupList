package com.anwesome.ui.verticalbuttongrouplist;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by anweshmishra on 27/05/17.
 */

public class VerticalButtonGroup extends ViewGroup {
    private int w,h,viewH,viewW;
    public VerticalButtonGroup(Context context) {
        super(context);
    }
    public void initDimension(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService(Context.DISPLAY_SERVICE);
        Display display = displayManager.getDisplay(0);
        if(display != null) {
            Point size = new Point();
            display.getRealSize(size);
            w = size.x;
            h = size.y;
            viewH = h/12;
        }
    }
    public void onMeasure(int wspec,int hspec) {
        int hMax = h/30;
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            measureChild(child,wspec,hspec);
            hMax += (child.getMeasuredHeight()+h/30);
        }
        setMeasuredDimension(w,hMax);
    }
    public void onLayout(boolean reloaded,int a,int b,int w,int h) {
        int y = h/30,x = w/10;
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            child.layout(x,y,x+child.getMeasuredWidth(),y+child.getMeasuredHeight());
            y += (child.getMeasuredHeight()+h/30);
        }
    }
    public void addButton(String text) {
    }
}
