package com.losersclub.swiper

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val swiper: Swiper = findViewById(R.id.swiper)

        val itemList = ArrayList<ViewItem>()
        val titles = arrayOf(
            "Material Design Principles Bold", "Material Design Principles Metaphor",
            "Material Design Principles Motion"
        )
        val images = intArrayOf(
            R.drawable.materialdesign_principles_bold,
            R.drawable.materialdesign_principles_metaphor,
            R.drawable.materialdesign_principles_motion
        )

        for (i in titles.indices) {
            itemList.add(ViewItem(titles[i], images[i]))
        }

        val fragmentList = arrayListOf(
            FragmentBold(), FragmentMetaphor(), FragmentMotion(),
            FragmentBold(), FragmentMetaphor()
        )

        swiper.setAdapter(Swiper.FragmentAdapter(this, fragmentList))
        //swiper.setAdapter(ViewItemAdapter(this, itemList))

        //swiper.setIndicator(Swiper.DotIndicator(this))
        //swiper.setPageTransformer(Swiper.DepthPageTransformer())
    }
}