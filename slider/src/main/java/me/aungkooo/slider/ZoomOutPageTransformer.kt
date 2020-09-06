package me.aungkooo.slider

import android.view.View
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs
import kotlin.math.max

/**
 * Created by Ko Oo on 26/5/2018.
 */
@Suppress("unused")
class ZoomOutPageTransformer : ViewPager.PageTransformer {
    companion object {
        private const val MIN_SCALE = 0.85f
        private const val MIN_ALPHA = 0.5f
    }

    override fun transformPage(page: View, position: Float) {
        val pageWidth = page.width
        val pageHeight = page.height
        when {
            position < -1 -> {
                // This page is way off-screen to the left
                page.alpha = 0f
            }
            position <= 1 -> {
                // Modify the default slide transition to shrink the page as well
                val scaleFactor = max(MIN_SCALE, 1 - abs(position))
                val verticalMargin = pageHeight * (1 - scaleFactor) / 2
                val horizontalMargin = pageWidth * (1 - scaleFactor) / 2
                if (position < 0) {
                    page.translationX = horizontalMargin - verticalMargin / 2
                } else {
                    page.translationX = -horizontalMargin + verticalMargin / 2
                }

                // Scale the page down (between MIN_SCALE and 1)
                page.scaleX = scaleFactor
                page.scaleY = scaleFactor

                // Fade the page relative to its size
                page.alpha = MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA)
            }
            else -> {
                // This page is way off-screen to the right
                page.alpha = 0f
            }
        }
    }
}