package com.begentgroup.samplegraphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016-08-03.
 */
public class CustomView extends View {

    public CustomView(Context context) {
        this(context, null);
    }

    Paint mPaint;
    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint();

        initPoint();
    }

    float[] points;
    private static final float START = 0, END = 600, INTERVAL = 20;
    private void initPoint() {
        int count = (int)((END - START) / INTERVAL) + 1;
        points = new float[count * 2 * 2];

        for (int i = 0; i < count; i++) {
            points[i * 4 + 0] = START;
            points[i * 4 + 1] = START + i * INTERVAL;
            points[i * 4 + 2] = END - i * INTERVAL;
            points[i * 4 + 3] = START;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.LTGRAY);

        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        canvas.drawLines(points, mPaint);
        mPaint.setAntiAlias(false);

        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(5);
        canvas.drawPoints(points, mPaint);
    }
}
