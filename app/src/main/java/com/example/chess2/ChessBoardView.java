package com.example.chess2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ChessBoardView extends View {

    private final Paint lightPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint darkPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public ChessBoardView(Context context) {
        super(context);
        init();
    }

    public ChessBoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        lightPaint.setColor(Color.parseColor("#EEEED2"));
        darkPaint.setColor(Color.parseColor("#769656"));
    }

    // Das Brett soll immer quadratisch sein
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        int size = Math.min(w, h);
        setMeasuredDimension(size, size);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float cell = getWidth() / 8f;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                // Feld a8 (links oben) ist hell, danach im Wechsel
                Paint paint = ((row + col) % 2 == 0) ? lightPaint : darkPaint;
                canvas.drawRect(col * cell, row * cell,
                        (col + 1) * cell, (row + 1) * cell, paint);
            }
        }
    }
}