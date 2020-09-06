package me.aungkooo.slider

import android.view.View
import androidx.viewpager.widget.ViewPager

/**
 * Created by Ko Oo on 26/5/2018.
 */
class DepthPageTransformer : ViewPager.PageTransformer {
    companion object {
        private const val MIN_SCALE = 0.75f
    }

    override fun transformPage(page: View, position: Float) {
        val pageWidth = page.width
        when {
            position < -1 -> {
                // This page is way off-screen to the left
                page.alpha = 0f
            }
            position <= 0 -> {
                // Use the default slide transition when moving to the left page
                page.alpha = 1f
                page.translationX = 0f
                page.scaleX = 1f
                page.scaleY = 1f
            }
            position <= 1 -> {
                // Fade the page out
                page.alpha = 1 - position

                // Counteract the default slide transition
                page.translationX = pageWidth * -position

                // Scale the page down (between MIN_SCALE and 1)
                val scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position))
                page.scaleX = scaleFactor
                page.scaleY = scaleFactor
            }
            else -> {
                // This page is way off-screen to the right
                page.alpha = 0f
            }
        }
    }
}