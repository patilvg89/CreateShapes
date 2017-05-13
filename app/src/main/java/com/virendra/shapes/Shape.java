package com.virendra.shapes;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by virendra
 */

public class Shape extends View {

    public Shape(Context context) {
        super(context);
    }

    public Shape(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Shape(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
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

    @Override
    protected void onDraw(Canvas canvas) {
        Path clipPath = new Path();
        clipPath.addPath(trapezoid());
        //clipPath.addPath(Hexagon());
        canvas.clipPath(clipPath);
        canvas.drawColor(Color.WHITE);

        super.onDraw(canvas);
    }

    private Path trapezoid() {
        float midx = getWidth() / 2;
        float midy = getHeight() / 2;

        int rowItemMargin = getLeft() != 0 ? getLeft() : getRight();//it is in pixels
        int bottomLeftRightMargin = rowItemMargin * 3;// check left/right margin and keep space double of lef/right margin

        Path p = new Path();
        p.moveTo(midx, midy);

        //1st quad
        p.lineTo(midx + (getWidth() / 2) - bottomLeftRightMargin, midy + getHeight() / 2);
        p.lineTo(midx, midy + getHeight() / 2);

        p.lineTo(midx - ((getWidth() / 2) - bottomLeftRightMargin), midy + getHeight() / 2);
        p.lineTo(midx - getWidth() / 2, midy - getHeight() / 2); // top left
        p.lineTo(midx + getWidth() / 2, midy - getHeight() / 2); // top right
        p.lineTo(midx + ((getWidth() / 2) - bottomLeftRightMargin), midy + getHeight() / 2);

        return p;
    }

    @Override
    public void setBackground(Drawable background) {
        super.setBackground(background);
    }

    int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }
}

