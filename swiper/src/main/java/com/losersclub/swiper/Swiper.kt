package com.losersclub.swiper

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

/**
 * Created by Ko Oo on 27/12/2021.
 */

class Swiper : RelativeLayout {
    private var viewPager2: ViewPager2
    private var indicator: Indicator? = null
    private var pageTransformer: ViewPager2.PageTransformer? = null
    private var iconActive: Drawable? = null
    private var iconInactive: Drawable? = null

    constructor(context: Context) : super(context) {
        viewPager2 = ViewPager2(context)
        viewPager2.id = R.id.swiper
        addView(viewPager2, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT))
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        viewPager2 = ViewPager2(context)
        viewPager2.id = R.id.swiper
        addView(viewPager2, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT))

        val a = context.obtainStyledAttributes(attrs, R.styleable.Swiper, 0, 0)
        iconActive = a.getDrawable(R.styleable.Swiper_swiperIndicatorActive)
        iconInactive = a.getDrawable(R.styleable.Swiper_swiperIndicatorInactive)
        when (a.getInt(R.styleable.Swiper_swiperPageTransformer, 1)) {
            1 -> setPageTransformer(DepthPageTransformer())
            2 -> setPageTransformer(ZoomOutPageTransformer())
        }
        a.recycle()
    }

    fun setAdapter(adapter: RecyclerView.Adapter<*>) {
        if (viewPager2.adapter == null) {
            viewPager2.adapter = adapter
        }

        setIndicator(Indicator(context, iconActive!!, iconInactive!!))
    }

    fun setIndicator(indicator: Indicator, align: Indicator.ALIGN) {
        if (this.indicator == null) {
            this.indicator = indicator
            indicator.iconActive = iconActive
            indicator.iconInactive = iconInactive
            indicator.attachToViewPager(viewPager2)

            val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            params.addRule(align.POSITION)
            params.setMargins(0, 36, 0, 36)
            addView(indicator, params)
        }
    }

    fun setIndicator(indicator: Indicator) {
        setIndicator(indicator, Indicator.ALIGN.BOTTOM)
    }

    fun setPageTransformer(pageTransformer: ViewPager2.PageTransformer) {
        if (this.pageTransformer == null) {
            this.pageTransformer = pageTransformer
            viewPager2.setPageTransformer(pageTransformer)
        }
    }

    fun addOnPageChangeCallback(callback: ViewPager2.OnPageChangeCallback) {
        viewPager2.registerOnPageChangeCallback(callback)
    }

    // FragmentAdapter
    class FragmentAdapter(
        fragmentActivity: FragmentActivity,
        var fragmentList: ArrayList<Fragment>
    ) : FragmentStateAdapter(
        fragmentActivity
    ) {
        override fun getItemCount(): Int {
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
        }
    }

    // ViewAdapter
    abstract class ViewAdapter<OBJ>(
        var context: Context,
        var itemList: ArrayList<OBJ>
    ) : RecyclerView.Adapter<ViewHolder>() {

        fun getItem(position: Int): OBJ {
            return itemList[position]
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    // Indicator
    open class Indicator : LinearLayout {
        enum class ALIGN(val POSITION: Int) {
            TOP(RelativeLayout.ALIGN_PARENT_TOP), BOTTOM(RelativeLayout.ALIGN_PARENT_BOTTOM), CENTER(
                RelativeLayout.CENTER_IN_PARENT
            )
        }

        private var childViewsCount = 0
        private lateinit var childViews: Array<ImageView?>
        var iconActive: Drawable? = null
        var iconInactive: Drawable? = null
        private var viewPager2: ViewPager2? = null

        // Default = DotIndicator
        constructor(context: Context) : super(context) {
            setIconDrawables(R.drawable.dot_active, R.drawable.dot_inactive)
            this.setPadding(0, 32, 0, 32)
            orientation = HORIZONTAL
            gravity = Gravity.CENTER
        }

        constructor(
            context: Context,
            @DrawableRes iconActive: Int,
            @DrawableRes iconInactive: Int
        ) : super(context) {
            setIconDrawables(iconActive, iconInactive)
            this.setPadding(0, 32, 0, 32)
            orientation = HORIZONTAL
            gravity = Gravity.CENTER
        }

        constructor(
            context: Context,
            iconActive: Drawable,
            iconInactive: Drawable
        ) : super(context) {
            setIconDrawables(iconActive, iconInactive)
            this.setPadding(0, 32, 0, 32)
            orientation = HORIZONTAL
            gravity = Gravity.CENTER
        }

        fun setIconDrawables(@DrawableRes iconActive: Int, @DrawableRes iconInactive: Int) {
            this.iconActive = AppCompatResources.getDrawable(context, iconActive)
            this.iconInactive = AppCompatResources.getDrawable(context, iconInactive)
        }

        fun setIconDrawables(iconActive: Drawable, iconInactive: Drawable) {
            this.iconActive = iconActive
            this.iconInactive = iconInactive
        }

        fun setChildViews(count: Int) {
            childViews = arrayOfNulls(count)
            for (i in 0 until count) {
                childViews[i] = ImageView(context)
                if (i == 0) {
                    childViews[i]!!.setImageDrawable(iconActive)
                } else {
                    childViews[i]!!.setImageDrawable(iconInactive)
                }
                val params = LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT
                )
                params.setMargins(10, 0, 10, 0)
                addView(childViews[i], params)
                childViews[i]?.setPadding(5, 5, 5, 5)

                childViews[i]?.setOnClickListener {
                    selectIndicator(i)
                    viewPager2?.setCurrentItem(i, false)
                }
            }
        }

        fun attachToViewPager(viewPager2: ViewPager2) {
            this.viewPager2 = viewPager2

            if (viewPager2.adapter != null) {
                childViewsCount = viewPager2.adapter!!.itemCount
                setChildViews(childViewsCount)
            }

            viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    selectIndicator(position)
                }
            })
        }

        private fun selectIndicator(position: Int) {
            for (i in 0 until childViewsCount) {
                if (i == position) {
                    childViews[i]!!.setImageDrawable(iconActive)
                } else {
                    childViews[i]!!.setImageDrawable(iconInactive)
                }
            }
        }
    }

    class BarIndicator(context: Context) : Indicator(
        context, R.drawable.bar_active, R.drawable.bar_inactive
    ) {
    }

    class DotIndicator(context: Context) : Indicator(
        context, R.drawable.dot_active, R.drawable.dot_inactive
    ) {
    }

    // PageTransformer
    class ZoomOutPageTransformer : ViewPager2.PageTransformer {
        private val MIN_SCALE = 0.85f
        private val MIN_ALPHA = 0.5f
        override fun transformPage(view: View, position: Float) {
            view.apply {
                val pageWidth = width
                val pageHeight = height
                when {
                    position < -1 -> { // [-Infinity,-1)
                        // This page is way off-screen to the left.
                        alpha = 0f
                    }
                    position <= 1 -> { // [-1,1]
                        // Modify the default slide transition to shrink the page as well
                        val scaleFactor = MIN_SCALE.coerceAtLeast(1 - abs(position))
                        val vertMargin = pageHeight * (1 - scaleFactor) / 2
                        val horzMargin = pageWidth * (1 - scaleFactor) / 2
                        translationX = if (position < 0) {
                            horzMargin - vertMargin / 2
                        } else {
                            horzMargin + vertMargin / 2
                        }

                        // Scale the page down (between MIN_SCALE and 1)
                        scaleX = scaleFactor
                        scaleY = scaleFactor

                        // Fade the page relative to its size.
                        alpha = (MIN_ALPHA +
                                (((scaleFactor - MIN_SCALE) / (1 - MIN_SCALE)) * (1 - MIN_ALPHA)))
                    }
                    else -> { // (1,+Infinity]
                        // This page is way off-screen to the right.
                        alpha = 0f
                    }
                }
            }
        }
    }

    @RequiresApi(21)
    class DepthPageTransformer : ViewPager2.PageTransformer {
        private val MIN_SCALE = 0.75f
        override fun transformPage(view: View, position: Float) {
            view.apply {
                val pageWidth = width
                when {
                    position < -1 -> { // [-Infinity,-1)
                        // This page is way off-screen to the left.
                        alpha = 0f
                    }
                    position <= 0 -> { // [-1,0]
                        // Use the default slide transition when moving to the left page
                        alpha = 1f
                        translationX = 0f
                        translationZ = 0f
                        scaleX = 1f
                        scaleY = 1f
                    }
                    position <= 1 -> { // (0,1]
                        // Fade the page out.
                        alpha = 1 - position

                        // Counteract the default slide transition
                        translationX = pageWidth * -position
                        // Move it behind the left page
                        translationZ = -1f

                        // Scale the page down (between MIN_SCALE and 1)
                        val scaleFactor = (MIN_SCALE + (1 - MIN_SCALE) * (1 - abs(position)))
                        scaleX = scaleFactor
                        scaleY = scaleFactor
                    }
                    else -> { // (1,+Infinity]
                        // This page is way off-screen to the right.
                        alpha = 0f
                    }
                }
            }
        }
    }
}
