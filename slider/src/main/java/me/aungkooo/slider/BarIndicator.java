package me.aungkooo.slider;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by Ko Oo on 26/5/2018.
 */

public class BarIndicator extends Indicator
{

    public BarIndicator(Context context) {
        super(context, R.drawable.bar_active, R.drawable.bar_inactive);
    }

    public BarIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setIconDrawables(R.drawable.bar_active, R.drawable.bar_inactive);
    }

    public BarIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BarIndicator(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
