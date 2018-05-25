package me.aungkooo.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Ko Oo on 25/5/2018.
 */

public class DotIndicator extends LinearLayout implements ViewPager.OnPageChangeListener
{
    private int dotCount;
    private ImageView[] dots;

    public static final int ALIGN_TOP = RelativeLayout.ALIGN_PARENT_TOP;
    public static final int ALIGN_BOTTOM = RelativeLayout.ALIGN_PARENT_BOTTOM;
    public static final int ALIGN_CENTER = RelativeLayout.CENTER_IN_PARENT;

    public DotIndicator(Context context, int dotCount) {
        super(context);
        this.dotCount = dotCount;

        setPadding(0, 16, 0, 16);
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER);

        dots = new ImageView[dotCount];

        for(int i = 0; i < dotCount; i++)
        {
            dots[i] = new ImageView(context);
            if(i == 0) {
                dots[i].setImageResource(R.drawable.dot_active);
            }
            else {
                dots[i].setImageResource(R.drawable.dot_inactive);
            }

            LinearLayout.LayoutParams dotsParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            dotsParams.setMargins(10, 0, 10, 0);

            addView(dots[i], dotsParams);
        }
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

    public void setViewPager(ViewPager viewPager)
    {
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for(int i = 0; i < dotCount; i++) {
            if(i == position) {
                dots[i].setImageResource(R.drawable.dot_active);
            }
            else {
                dots[i].setImageResource(R.drawable.dot_inactive);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
