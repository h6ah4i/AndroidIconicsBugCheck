package com.h6ah4i.android.example.androidiconicsbugcheck;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.widget.Button;

import com.mikepenz.iconics.Iconics;

/**
 * Created by hasegawa on 8/25/15.
 */
public class FixedIconicsButton extends Button {
    public FixedIconicsButton(Context context) {
        super(context);
        // Do not set typeface here
    }

    public FixedIconicsButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        // Do not set typeface here
    }

    public FixedIconicsButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // Do not set typeface here
    }

    public void setText(CharSequence text, BufferType type) {
        // NOTES:
        // 1. Need to disable the All Caps option to make Spannable work properly!
        // 2. This method will be called from the constructor of the super class
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            setAllCaps(false);
        }

        if(!this.isInEditMode()) {
            super.setText((new Iconics.IconicsBuilder()).ctx(this.getContext()).on(text).build(), type);
        } else {
            super.setText(text, type);
        }
    }
}
