package me.aungkooo.imageslider

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import me.aungkooo.imageslider.databinding.ViewHeaderBinding

class HeaderItemView(context: Context) : FrameLayout(context) {

    private val binding: ViewHeaderBinding = ViewHeaderBinding.inflate(LayoutInflater.from(context), this, true)

    val cardViewHeader: CardView
        get() = binding.cardViewHeader
    val imageHeader: ImageView
        get() = binding.imgHeader
    val textHeader: TextView
        get() = binding.txtHeader

}