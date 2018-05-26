package me.aungkooo.slider;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by Ko Oo on 26/5/2018.
 */

public class DotIndicator extends Indicator
{
    public DotIndicator(Context context) {
        super(context, R.drawable.dot_active, R.drawable.dot_inactive);
    }

    private DotIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private DotIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private DotIndicator(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
