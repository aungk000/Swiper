package me.aungkooo.imageslider

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import me.aungkooo.imageslider.databinding.ActivityMainBinding
import me.aungkooo.imageslider.fragment.BoldFragment
import me.aungkooo.imageslider.fragment.MetaphorFragment
import me.aungkooo.imageslider.fragment.MotionFragment
import me.aungkooo.slider.DepthPageTransformer
import me.aungkooo.slider.DotIndicator
import me.aungkooo.slider.FragmentAdapter
import java.util.*

class MainActivity : AppCompatActivity() {

    private val showViewSlider = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val itemList = mutableListOf<HeaderItem>()
        val titles = arrayOf(
                getString(R.string.material_design_principles_bold),
                getString(R.string.material_design_principles_metaphor),
                getString(R.string.material_design_principles_motion)
        )

        val images = intArrayOf(R.drawable.materialdesign_principles_bold,
                R.drawable.materialdesign_principles_metaphor,
                R.drawable.materialdesign_principles_motion)

        titles.forEachIndexed { index, title ->
            itemList.add(HeaderItem(title, images[index]))
        }

        if (showViewSlider) {
            binding.slider.viewAdapter = ViewBindingSliderAdapter(this, itemList)
        } else {
            val fragmentList = ArrayList<Fragment>()
            val fragments = arrayOf(BoldFragment(), MetaphorFragment(), MotionFragment())
            Collections.addAll(fragmentList, *fragments)
            binding.slider.fragmentAdapter = FragmentAdapter(supportFragmentManager, fragmentList)
        }

        binding.slider.setIndicator(DotIndicator(this))
        binding.slider.setPageTransformer(DepthPageTransformer())
    }
}