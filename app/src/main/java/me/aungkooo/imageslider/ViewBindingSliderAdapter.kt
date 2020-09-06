package me.aungkooo.imageslider

import android.content.Context
import android.view.ViewGroup
import android.widget.Toast
import com.squareup.picasso.Picasso
import me.aungkooo.slider.ViewAdapter

class ViewBindingSliderAdapter(context: Context, itemList: List<HeaderItem>) : ViewAdapter<HeaderItemView, HeaderItem>(context, itemList) {

    override fun onCreateView(container: ViewGroup): HeaderItemView {
        return HeaderItemView(context)
    }

    override fun onBindView(container: ViewGroup, view: HeaderItemView, item: HeaderItem, position: Int) {
        Picasso.with(context).load(item.imageResource)
                .centerCrop().resize(720, 720).into(view.imageHeader)
        view.textHeader.text = item.title
        view.cardViewHeader.setOnClickListener { Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show() }
    }

}