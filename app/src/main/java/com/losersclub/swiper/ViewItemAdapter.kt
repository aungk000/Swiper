package com.losersclub.swiper

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView

class ViewItemAdapter(context: Context, itemList: ArrayList<ViewItem>) :
    Swiper.ViewAdapter<ViewItem>(context, itemList) {
    private lateinit var imgHeader: ImageView
    private lateinit var txtHeader: TextView
    private lateinit var cardViewHeader: CardView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Swiper.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_item, parent, false)
        imgHeader = view.findViewById(R.id.img_header)
        txtHeader = view.findViewById(R.id.txt_header)
        cardViewHeader = view.findViewById(R.id.card_view_header)
        return Swiper.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Swiper.ViewHolder, position: Int) {
        val item = getItem(position)
        imgHeader.setImageResource(item.imageResource)
        txtHeader.text = item.title
        cardViewHeader.setOnClickListener {
            Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}