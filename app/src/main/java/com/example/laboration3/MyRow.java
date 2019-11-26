package com.example.laboration3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;


public class MyRow extends View {
    Paint p;
    String name;

    public MyRow(Context context, String name) {
        super(context);
        this.name = name;
    }

    public MyRow(Context context, @Nullable AttributeSet attrs, String name) {
        super(context, attrs);
        this.name = name;
    }

    public MyRow(Context context, @Nullable AttributeSet attrs, int defStyleAttr, String name) {
        super(context, attrs, defStyleAttr);
        this.name = name;
    }

    public void onDraw(Canvas canvas) {


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
