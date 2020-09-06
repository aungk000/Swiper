package me.aungkooo.slider

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.viewpager.widget.PagerAdapter
import java.util.*

/**
 * Created by Ko Oo on 25/5/2018.
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
abstract class ViewAdapter<V : View?, OBJ> : PagerAdapter {
    val context: Context
    var itemList: List<OBJ>
        private set
    var view: V? = null
        private set

    constructor(context: Context) {
        this.context = context
        itemList = ArrayList()
    }

    constructor(context: Context, itemList: List<OBJ>) {
        this.context = context
        this.itemList = itemList
    }

    fun setItemList(itemList: ArrayList<OBJ>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }

    fun getItem(position: Int): OBJ {
        return itemList[position]
    }

    fun createView(@LayoutRes resId: Int, container: ViewGroup?): V {
        @Suppress("UNCHECKED_CAST")
        return LayoutInflater.from(context).inflate(resId, container, false) as V
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        view = onCreateView(container)
        val item = getItem(position)
        onBindView(container, view, item, position)
        container.addView(view)
        return view as Any
    }

    override fun getCount(): Int {
        return itemList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    abstract fun onCreateView(container: ViewGroup?): V
    abstract fun onBindView(container: ViewGroup?, view: V?, item: OBJ, position: Int)
}