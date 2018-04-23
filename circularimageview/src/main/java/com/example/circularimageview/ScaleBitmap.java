package com.example.circularimageview;

import android.graphics.Bitmap;

/**
 * Created by emmanuel on 3/12/2018.
 */

public class ScaleBitmap {

    public static Bitmap getScaledBitmap(Bitmap initialBitmap, int width, int height){

        return Bitmap.createScaledBitmap(initialBitmap, width, height, false);

    }
}
