package com.anwesome.ui.verticalbuttongrouplistdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anwesome.ui.verticalbuttongrouplist.VerticalButtonGroupHolder;

public class MainActivity extends AppCompatActivity {
    private String titles[] = {"Hello","Hert","Bye","Tick","MoreButtonMoreFun"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        VerticalButtonGroupHolder verticalButtonGroupHolder = new VerticalButtonGroupHolder(this);
        for(int i=0;i<titles.length;i++) {
            verticalButtonGroupHolder.addButton(titles[i]);
        }
        verticalButtonGroupHolder.show();
    }
}
