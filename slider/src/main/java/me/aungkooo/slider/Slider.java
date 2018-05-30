package me.aungkooo.slider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import java.security.InvalidParameterException;

/**
 * Created by Ko Oo on 25/5/2018.
 */

public class Slider extends RelativeLayout
{
    private ViewPager viewPager;
    private ViewAdapter viewAdapter;
    private FragmentAdapter fragmentAdapter;

    public Slider(Context context) {
        super(context);
    }

    public Slider(Context context, AttributeSet attrs) {
        super(context, attrs);

        viewPager = new ViewPager(context);
        // int viewpagerId = View.generateViewId();
        viewPager.setId(R.id.view_pager_slider);

        RelativeLayout.LayoutParams params = getChildLayoutParams();
        addView(viewPager, params);
    }

    @NonNull
    private RelativeLayout.LayoutParams getChildLayoutParams() {
        return new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    }

    public void setViewAdapter(ViewAdapter viewAdapter) {
        if(viewAdapter == null) {
            throw new InvalidParameterException("Adapter must not be null");
        }

        viewPager.setAdapter(viewAdapter);
        this.viewAdapter = viewAdapter;
    }

    public ViewAdapter getViewAdapter() {
        if(viewAdapter == null) {
            throw new NullPointerException("Adapter must not be null");
        }

        return viewAdapter;
    }

    public ViewPager getViewPager() {
        return viewPager;
    }

    public void setFragmentAdapter(FragmentAdapter fragmentAdapter) {
        if(fragmentAdapter == null) {
            throw new InvalidParameterException("Adapter must not be null");
        }

        viewPager.setAdapter(fragmentAdapter);
        this.fragmentAdapter = fragmentAdapter;
    }

    public FragmentAdapter getFragmentAdapter() {
        if(fragmentAdapter == null) {
            throw new NullPointerException("Adapter must not be null");
        }

        return fragmentAdapter;
    }

    public void setIndicator(Indicator indicator, Indicator.ALIGN align)
    {
        indicator.attachToViewPager(viewPager);

        RelativeLayout.LayoutParams params = getChildLayoutParams();
        params.addRule(align.POSITION);
        params.setMargins(0, 36, 0, 36);

        addView(indicator, params);
    }

    public void setIndicator(Indicator indicator) {
        setIndicator(indicator, Indicator.ALIGN.BOTTOM);
    }

    public void setPageTransformer(ViewPager.PageTransformer pageTransformer) {
        viewPager.setPageTransformer(true, pageTransformer);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        viewPager.addOnPageChangeListener(listener);
    }

    public Slider(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Slider(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
