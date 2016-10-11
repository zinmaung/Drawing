package edu.cascadia.brianb.mydrawing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Edited by Brian Bansenauer on 10/18/15.
 */
public class SimplyDrawnView extends View {

    private Paint mPaint;
    private Path mPath;
    private float mWidth, mHeight;

    public SimplyDrawnView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        mPaint = new Paint();
        mPath = new Path();
     }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE); //draw background

        //Draw line
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(16.0f);
        canvas.drawLine(mWidth, 0, 200, mHeight, mPaint);

        //Draw red line
        mPaint.setColor(Color.RED); mPaint.setStrokeWidth(10);

        mPaint.setColor(Color.GREEN);//Draw green lines
        mPaint.setStrokeWidth(21.0f);
        canvas.drawLine(mWidth, 500, -1000, mHeight, mPaint);//Draw Text

        mPath.addCircle(500f, 1000f, 150f, Path.Direction.CCW);//Draw Text on a Path
        mPaint.setColor(Color.BLUE);
        mPaint.setTextSize(81);
        canvas.drawTextOnPath("Something is floating here", mPath, 50f, 300f, mPaint);//Draw filled, opaque, and open ovals

        //Draw bee bitmap
        BitmapDrawable b = (BitmapDrawable) getResources().getDrawable(R.drawable.bee,null);
        canvas.drawBitmap(b.getBitmap(), 300f, 800f, mPaint);
        //Add another image to drawable and draw it

    }
}
