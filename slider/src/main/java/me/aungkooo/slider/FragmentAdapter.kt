package me.aungkooo.slider

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import java.util.*

/**
 * Created by Ko Oo on 30/5/2018.
 */
@Suppress("unused")
class FragmentAdapter : FragmentStatePagerAdapter {
    private var fragmentList: ArrayList<Fragment>? = null

    constructor(fm: FragmentManager?) : super(fm)

    constructor(fm: FragmentManager?, fragmentList: ArrayList<Fragment>?) : super(fm) {
        this.fragmentList = fragmentList
    }

    fun setFragmentList(fragmentList: ArrayList<Fragment>?) {
        this.fragmentList = fragmentList
        notifyDataSetChanged()
    }

    fun getFragmentList(): ArrayList<Fragment>? {
        return fragmentList
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList!![position]
    }

    override fun getCount(): Int {
        return fragmentList!!.size
    }
}