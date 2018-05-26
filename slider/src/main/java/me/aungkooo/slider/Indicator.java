package me.aungkooo.slider;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Ko Oo on 26/5/2018.
 */

public class Indicator extends LinearLayout implements ViewPager.OnPageChangeListener
{
    public static final int ALIGN_TOP = RelativeLayout.ALIGN_PARENT_TOP;
    public static final int ALIGN_BOTTOM = RelativeLayout.ALIGN_PARENT_BOTTOM;
    public static final int ALIGN_CENTER = RelativeLayout.CENTER_IN_PARENT;

    private int childCount;
    private ImageView[] childViews;
    private @DrawableRes int indicatorActive, indicatorInactive;

    public Indicator(Context context, @DrawableRes int indicatorActive, @DrawableRes int indicatorInactive) {
        super(context);
        this.indicatorActive = indicatorActive;
        this.indicatorInactive = indicatorInactive;

        setPadding(0, 32, 0, 32);
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER);
    }

    public void setChildViews(int childCount) {
        this.childCount = childCount;

        childViews = new ImageView[childCount];

        for(int i = 0; i < childCount; i++)
        {
            childViews[i] = new ImageView(getContext());
            if(i == 0) {
                childViews[i].setImageResource(indicatorActive);
            }
            else {
                childViews[i].setImageResource(indicatorInactive);
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(10, 0, 10, 0);

            addView(childViews[i], params);
        }
    }

    public void setOnPageChangeListener(ViewPager viewPager)
    {
        viewPager.addOnPageChangeListener(this);
    }

    public Indicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Indicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Indicator(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for(int i = 0; i < childCount; i++) {
            if(i == position) {
                childViews[i].setImageResource(indicatorActive);
            }
            else {
                childViews[i].setImageResource(indicatorInactive);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
