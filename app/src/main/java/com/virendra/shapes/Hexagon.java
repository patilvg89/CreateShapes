package com.virendra.shapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by bhagwang on 5/19/17.
 */

public class Hexagon extends View {
    public Hexagon(Context context) {
        super(context);
    }

    public Hexagon(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Hexagon(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Hexagon(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path clipPath = new Path();
        clipPath.addPath(Hexagon());
        canvas.clipPath(clipPath);
        canvas.drawColor(Color.MAGENTA);
    }


    private Path Hexagon() {
        float midx = getWidth() / 2;
        float midy = getHeight() / 2;
        Path p = new Path();
        p.moveTo(midx, midy);
        p.lineTo(midx + 150, midy + 220);
        p.lineTo(midx, midy + 220);
        p.lineTo(midx - 150, midy + 220);
        p.lineTo(midx - 300, midy);
        p.lineTo(midx - 150, midy - 220);
        p.lineTo(midx + 150, midy - 220);
        p.lineTo(midx + 300, midy);
        p.lineTo(midx + 150, midy + 220);
        return p;
    }
}
