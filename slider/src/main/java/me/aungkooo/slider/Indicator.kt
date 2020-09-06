package me.aungkooo.slider

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.annotation.DrawableRes
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener

/**
 * Created by Ko Oo on 26/5/2018.
 */
open class Indicator : LinearLayout, OnPageChangeListener {
    @Suppress("unused")
    enum class ALIGN(val POSITION: Int) {
        TOP(RelativeLayout.ALIGN_PARENT_TOP),
        BOTTOM(RelativeLayout.ALIGN_PARENT_BOTTOM),
        CENTER(RelativeLayout.CENTER_IN_PARENT);
    }

    private var iconActive: Drawable? = null
    private var iconInactive: Drawable? = null

    constructor(context: Context, @DrawableRes iconActive: Int, @DrawableRes iconInactive: Int) : super(context) {
        this.iconActive = context.getDrawable(iconActive)
        this.iconInactive = context.getDrawable(iconInactive)
        orientation = HORIZONTAL
        gravity = Gravity.CENTER
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        setPadding(0, 32, 0, 32)
    }

    fun setIconDrawables(@DrawableRes iconActive: Int, @DrawableRes iconInactive: Int) {
        this.iconActive = context.getDrawable(iconActive)
        this.iconInactive = context.getDrawable(iconInactive)
    }

    private fun setChildViews(childCount: Int) {
        val childViews = arrayOfNulls<ImageView?>(childCount)
        for (i in 0 until childCount) {
            childViews[i] = ImageView(context)
            if (i == 0) {
                childViews[i]!!.setImageDrawable(iconActive)
            } else {
                childViews[i]!!.setImageDrawable(iconInactive)
            }
            val params = LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            params.setMargins(10, 0, 10, 0)
            addView(childViews[i], params)
        }
    }

    fun attachToViewPager(viewPager: ViewPager?) {
        viewPager!!.addOnPageChangeListener(this)

        viewPager.adapter?.let { adapter ->
            setChildViews(adapter.count)
        } ?: throw NullPointerException("Adapter must not be null")
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER
        val a = context.obtainStyledAttributes(attrs, R.styleable.Indicator, 0, 0)
        iconActive = a.getDrawable(R.styleable.Indicator_iconActive)
        iconInactive = a.getDrawable(R.styleable.Indicator_iconInactive)
        a.recycle()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    private fun selectIndicator(position: Int) {
        for (i in 0 until childCount) {
            getChildImageViewAt(i)?.let { imageView ->
                val drawable = getIndicatorDrawable(i, position)
                drawable?.let {
                    imageView.setImageDrawable(drawable)
                }
            }
        }
    }

    private fun getIndicatorDrawable(i: Int, position: Int): Drawable? {
        return if (i == position) {
            iconActive
        } else {
            iconInactive
        }
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {
        selectIndicator(position)
    }

    override fun onPageScrollStateChanged(state: Int) {}

    private fun ViewGroup.getChildImageViewAt(position: Int): ImageView? {
        return getChildAt(position) as ImageView
    }
}