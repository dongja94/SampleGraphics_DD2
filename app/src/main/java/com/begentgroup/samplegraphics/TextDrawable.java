package com.begentgroup.samplegraphics;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2016-08-04.
 */
public class TextDrawable extends Drawable {
    Paint mPaint;
    String message;

    public TextDrawable(Resources res, String message) {
        this.message = message;
        mPaint = new Paint();
        mPaint.setTextSize(20);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mIntrisicWidth = (int)(mPaint.measureText(message, 0, message.length()) + 0.5f);
        mIntrisicHeight = (int)mPaint.getTextSize();
    }

    int mIntrisicWidth, mIntrisicHeight;

    @Override
    public int getIntrinsicWidth() {
        return mIntrisicWidth;
    }

    @Override
    public int getIntrinsicHeight() {
        return mIntrisicWidth;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawText(message, getBounds().centerX(), getBounds().centerY(), mPaint);
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return mPaint.getAlpha();
    }
}
