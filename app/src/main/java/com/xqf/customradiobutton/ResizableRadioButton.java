package com.xqf.customradiobutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
/**
 * 可以设置图片大小的RadioButton
 */


public class ResizableRadioButton extends RadioButton {

    private int mDrawableHeight;//xml文件中设置的高度
    private int mDrawableWidth;//xml文件中设置的宽度

    public ResizableRadioButton(Context context) {
        this(context, null, 0);
    }

    public ResizableRadioButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ResizableRadioButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        Drawable drawableLeft = null, drawableTop = null, drawableRight = null, drawableBottom = null;
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.ResizableRadioButton);
        setClickable(true);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.ResizableRadioButton_drawableHeight:
                    mDrawableHeight = a.getDimensionPixelSize(R.styleable.ResizableRadioButton_drawableHeight, 50);
                    break;
                case R.styleable.ResizableRadioButton_drawableWidth:
                    mDrawableWidth = a.getDimensionPixelSize(R.styleable.ResizableRadioButton_drawableWidth, 50);
                    break;
                case R.styleable.ResizableRadioButton_drawableTop:
                    drawableTop = a.getDrawable(attr);
                    break;
                case R.styleable.ResizableRadioButton_drawableBottom:
                    drawableRight = a.getDrawable(attr);
                    break;
                case R.styleable.ResizableRadioButton_drawableRight:
                    drawableBottom = a.getDrawable(attr);
                    break;
                case R.styleable.ResizableRadioButton_drawableLeft:
                    drawableLeft = a.getDrawable(attr);
                    break;
            }
        }
        a.recycle();

        setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom);

    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left,
                                                        Drawable top, Drawable right, Drawable bottom) {

        if (left != null) {
            left.setBounds(0, 0, mDrawableWidth, mDrawableHeight);
        }
        if (right != null) {
            right.setBounds(0, 0, mDrawableWidth, mDrawableHeight);
        }
        if (top != null) {
            top.setBounds(0, 0, mDrawableWidth, mDrawableHeight);
        }
        if (bottom != null) {
            bottom.setBounds(0, 0, mDrawableWidth, mDrawableHeight);
        }
        setCompoundDrawables(left, top, right, bottom);
    }
}
