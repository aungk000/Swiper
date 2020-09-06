package me.aungkooo.slider

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import me.aungkooo.slider.Indicator.ALIGN
import java.security.InvalidParameterException

/**
 * Created by Ko Oo on 25/5/2018.
 */

@Suppress("MemberVisibilityCanBePrivate", "unused")
class Slider : RelativeLayout {

    var viewPager: ViewPager? = null
        private set

    var viewAdapter: ViewAdapter<*, *>? = null
        get() {
            if (field == null) {
                throw NullPointerException("Adapter must not be null")
            }
            return field
        }
        set(viewAdapter) {
            viewAdapter?.let { adapter ->
                viewPager?.apply {
                    this@apply.adapter = adapter
                }
            } ?: throw InvalidParameterException("Adapter must not be null")
            field = viewAdapter
        }

    var fragmentAdapter: FragmentAdapter? = null
        get() {
            if (field == null) {
                throw NullPointerException("Adapter must not be null")
            }
            return field
        }
        set(fragmentAdapter) {
            fragmentAdapter?.let { adapter ->
                viewPager?.apply {
                    this@apply.adapter = adapter
                }
            } ?: throw InvalidParameterException("Adapter must not be null")
            field = fragmentAdapter
        }

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        viewPager = ViewPager(context!!)
        // int viewpagerId = View.generateViewId();
        viewPager?.apply {
            this@apply.id = R.id.view_pager_slider
        }
        val params = childLayoutParams
        addView(viewPager, params)
    }

    private val childLayoutParams: LayoutParams
        get() = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

    fun setIndicator(indicator: Indicator, align: ALIGN) {
        indicator.attachToViewPager(viewPager)
        val params = childLayoutParams
        params.addRule(align.POSITION)
        params.setMargins(0, 36, 0, 36)
        addView(indicator, params)
    }

    fun setIndicator(indicator: Indicator) {
        setIndicator(indicator, ALIGN.BOTTOM)
    }

    fun setPageTransformer(pageTransformer: ViewPager.PageTransformer?) {
        viewPager?.apply {
            this@apply.setPageTransformer(true, pageTransformer)
        }
    }

    fun setOnPageChangeListener(listener: OnPageChangeListener?) {
        listener?.let { onPageChangeListener ->
            viewPager?.apply {
                this@apply.addOnPageChangeListener(onPageChangeListener)
            }
        }
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)
}