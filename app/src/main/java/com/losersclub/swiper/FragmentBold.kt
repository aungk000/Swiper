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

class FragmentBold : Fragment() {

    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater, @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_bold, container, false)

        val txtBold: TextView = view.findViewById(R.id.txt_bold)
        val imgBold: ImageView = view.findViewById(R.id.img_bold)
        val relativeLayoutBold: RelativeLayout = view.findViewById(R.id.relative_layout_bold)

        txtBold.setText(R.string.material_design_principles_bold)
        imgBold.setImageResource(R.drawable.materialdesign_principles_bold)
        relativeLayoutBold.setBackgroundColor(Color.parseColor("#ffd180"))

        return view
    }
}