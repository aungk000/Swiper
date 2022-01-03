package com.losersclub.swiper


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment

/**
 * Created by Ko Oo on 30/5/2018.
 */

class FragmentMetaphor : Fragment() {

    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater, @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_metaphor, container, false)

        val txtBold: TextView = view.findViewById(R.id.txt_metaphor)
        val imgBold: ImageView = view.findViewById(R.id.img_metaphor)
        val relativeLayoutBold: RelativeLayout = view.findViewById(R.id.relative_layout_metaphor)

        txtBold.setText(R.string.material_design_principles_metaphor)
        imgBold.setImageResource(R.drawable.materialdesign_principles_metaphor)
        relativeLayoutBold.setBackgroundColor(Color.parseColor("#03a9f4"))

        return view
    }
}