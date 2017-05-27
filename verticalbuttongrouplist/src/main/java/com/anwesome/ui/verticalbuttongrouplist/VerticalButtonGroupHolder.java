package com.anwesome.ui.verticalbuttongrouplist;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by anweshmishra on 27/05/17.
 */

public class VerticalButtonGroupHolder  {
    private RelativeLayout relativeLayout;
    private VerticalButtonGroup verticalButtonGroup;
    private Activity activity;
    private boolean isShown = false;
    public VerticalButtonGroupHolder(Activity activity) {
        this.activity = activity;
        relativeLayout = new RelativeLayout(activity);
        verticalButtonGroup = new VerticalButtonGroup(activity);
    }
    public void addButton(String text) {
        if(!isShown) {
            verticalButtonGroup.addButton(text);
        }
    }
    public void show() {
        if(!isShown) {
            verticalButtonGroup.setBackgroundColor(Color.WHITE);
            relativeLayout.addView(verticalButtonGroup,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            relativeLayout.setBackgroundColor(Color.BLACK);
            activity.setContentView(relativeLayout);
            isShown = true;
        }
    }
}
