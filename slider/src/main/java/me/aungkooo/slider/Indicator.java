package me.aungkooo.slider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
    public enum ALIGN {
        TOP(RelativeLayout.ALIGN_PARENT_TOP),
        BOTTOM(RelativeLayout.ALIGN_PARENT_BOTTOM),
        CENTER(RelativeLayout.CENTER_IN_PARENT);

        final int POSITION;

        ALIGN(int position) {
            this.POSITION = position;
        }
    }

    private int childCount;
    private ImageView[] childViews;
    private Drawable iconActive, iconInactive;

    public Indicator(Context context, @DrawableRes int iconActive, @DrawableRes int iconInactive) {
        super(context);
        this.iconActive = context.getDrawable(iconActive);
        this.iconInactive = context.getDrawable(iconInactive);

        setPadding(0, 32, 0, 32);
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER);
    }

    public void setIconDrawables(@DrawableRes int iconActive, @DrawableRes int iconInactive) {
        this.iconActive = getContext().getDrawable(iconActive);
        this.iconInactive = getContext().getDrawable(iconInactive);
    }

    public void setChildViews(int childCount) {
        this.childCount = childCount;

        childViews = new ImageView[childCount];

        for(int i = 0; i < childCount; i++)
        {
            childViews[i] = new ImageView(getContext());
            if(i == 0) {
                childViews[i].setImageDrawable(iconActive);
            }
            else {
                childViews[i].setImageDrawable(iconInactive);
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(10, 0, 10, 0);

            addView(childViews[i], params);
        }
    }

    public void attachToViewPager(ViewPager viewPager) {
        viewPager.addOnPageChangeListener(this);

        if(viewPager.getAdapter() == null) {
            throw new NullPointerException("Adapter must not be null");
        }
        else {
            childCount = viewPager.getAdapter().getCount();
            setChildViews(childCount);
        }
    }

    public Indicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Indicator, 0, 0);
        iconActive = a.getDrawable(R.styleable.Indicator_iconActive);
        iconInactive = a.getDrawable(R.styleable.Indicator_iconInactive);

        a.recycle();
    }

    public Indicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Indicator(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void selectIndicator(int position)
    {
        for(int i = 0; i < childCount; i++) {
            if(i == position) {
                childViews[i].setImageDrawable(iconActive);
            }
            else {
                childViews[i].setImageDrawable(iconInactive);
            }
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        selectIndicator(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
