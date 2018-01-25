package com.szhrnet.taoqiapp.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : CenterDrawableTextView类
 *     email:15695947865@139.com
 * </pre>
 */

@SuppressLint("AppCompatCustomView")
public class CenterDrawableTextView extends TextView {
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CenterDrawableTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public CenterDrawableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CenterDrawableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CenterDrawableTextView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        CenterDrawableHelper.preDraw(this, canvas);
        super.onDraw(canvas);
    }
}
