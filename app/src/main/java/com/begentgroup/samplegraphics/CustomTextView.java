package com.begentgroup.samplegraphics;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016-08-04.
 */
public class CustomTextView extends View {
    TextDrawable textDrawable;
    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        textDrawable = new TextDrawable(context.getResources(), "Hello, World");
        textDrawable.setCallback(this);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (textDrawable != null) {
            int textWidth = textDrawable.getIntrinsicWidth();
            int textHeight = textDrawable.getIntrinsicHeight();

            int widht = getMeasuredWidth();
            int height = getMeasuredHeight();

            int left1 = (widht - textWidth) / 2;
            int top1 = (height - textHeight) / 2;
            int right1 = left + textWidth;
            int bottom1 = top + textHeight;

            textDrawable.setBounds(left1, top1, right1, bottom1);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (textDrawable != null) {
            textDrawable.draw(canvas);
        }
    }
}
