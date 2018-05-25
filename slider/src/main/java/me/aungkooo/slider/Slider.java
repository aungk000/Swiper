package me.aungkooo.slider;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import java.security.InvalidParameterException;

/**
 * Created by Ko Oo on 25/5/2018.
 */

public class Slider extends RelativeLayout
{
    private ViewPager viewPager;
    private DotIndicator dotIndicator;
    private SliderAdapter sliderAdapter;

    public Slider(Context context) {
        super(context);
    }

    public Slider(Context context, AttributeSet attrs) {
        super(context, attrs);

        viewPager = new ViewPager(context);

        RelativeLayout.LayoutParams params = getChildLayoutParams();
        addView(viewPager, params);
    }

    private RelativeLayout.LayoutParams getChildLayoutParams()
    {
        return new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    }

    public void setAdapter(SliderAdapter adapter)
    {
        if(adapter == null) {
            throw new InvalidParameterException("Adapter must not be null");
        }

        viewPager.setAdapter(adapter);
        sliderAdapter = adapter;
    }

    public void setDotIndicator(int align)
    {
        if(sliderAdapter == null) {
            throw new InvalidParameterException("Adapter must not be null");
        }

        int dotCount = sliderAdapter.getCount();
        dotIndicator = new DotIndicator(getContext(), dotCount);
        dotIndicator.setViewPager(viewPager);

        RelativeLayout.LayoutParams params = getChildLayoutParams();
        params.addRule(align);
        params.setMargins(0, 32, 0, 32);
        addView(dotIndicator, params);
    }

    public void setPageTransformer(ViewPager.PageTransformer pageTransformer)
    {
        viewPager.setPageTransformer(true, pageTransformer);
    }

    public Slider(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Slider(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
