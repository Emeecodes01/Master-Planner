package com.example.circularimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;



/**
 * Created by emmanuel on 3/11/2018.
 */

public class CircularImageView extends View{
    private Bitmap userImage, circularBitmap;
    private int defaultWidth, defaultHeight;
    private Paint imagePaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public CircularImageView(Context context) {
        this(context, null);
    }

    public CircularImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircularImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = null;
        defaultWidth = getResources().getDimensionPixelSize(R.dimen.default_width);
        defaultHeight = getResources().getDimensionPixelSize(R.dimen.default_heigth);

        try {
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircularImageView, 0, 0);
            Drawable imageDrawable = typedArray.getDrawable(R.styleable.CircularImageView_imageSrc);
            if (imageDrawable != null) {
                userImage = ((BitmapDrawable) imageDrawable).getBitmap();
                circularBitmap = CircularBitmap.getCircularBitmap(ScaleBitmap.getScaledBitmap(userImage,defaultWidth, defaultHeight));
            }

        }finally {
            typedArray.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        int height = View.MeasureSpec.getSize(heightMeasureSpec);


        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);

        int imageWidth = getFinalMesure(width, widthMode);
        int imageHeight = getFinalMesure(height, heightMode);

        setMeasuredDimension(imageWidth, imageHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth()/2;
        int heigth = getHeight()/2;
        int radius = (int) (width/2.6);

        if (userImage != null){
            canvas.drawBitmap(circularBitmap, (getWidth() - userImage.getWidth())/2, (getHeight() - userImage.getHeight())/2, imagePaint);
        }
    }

    private int getFinalMesure(int dimension, int mesureSpec){
        switch (mesureSpec){
            case MeasureSpec.EXACTLY:
                return dimension;
            case MeasureSpec.AT_MOST:
                return defaultHeight;
            case MeasureSpec.UNSPECIFIED:
                return defaultWidth;
        }
        return 0;
    }

}
