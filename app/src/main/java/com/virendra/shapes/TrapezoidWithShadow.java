package com.virendra.shapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by bhagwang on 5/19/17.
 */

public class TrapezoidWithShadow extends View {
    public TrapezoidWithShadow(Context context) {
        super(context);
    }

    public TrapezoidWithShadow(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TrapezoidWithShadow(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TrapezoidWithShadow(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setShadowLayer(12, 0, 0, Color.RED);
        paint.setStyle(Paint.Style.FILL);

        // this check is needed in order to get this code working if target SDK>=11
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(View.LAYER_TYPE_SOFTWARE, paint);
        }

        canvas.drawPath(trapezoid(), paint);

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
}
