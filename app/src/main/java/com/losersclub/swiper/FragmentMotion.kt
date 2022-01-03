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

class FragmentMotion : Fragment() {

    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater, @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_motion, container, false)

        val txtBold: TextView = view.findViewById(R.id.txt_motion)
        val imgBold: ImageView = view.findViewById(R.id.img_motion)
        val relativeLayoutBold: RelativeLayout = view.findViewById(R.id.relative_layout_motion)

        txtBold.setText(R.string.material_design_principles_motion)
        imgBold.setImageResource(R.drawable.materialdesign_principles_motion)
        relativeLayoutBold.setBackgroundColor(Color.parseColor("#ffffff"))

        return view
    }
}