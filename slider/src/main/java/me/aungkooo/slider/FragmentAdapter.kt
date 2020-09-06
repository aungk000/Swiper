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

    constructor(fm: FragmentManager) : super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)

    constructor(fm: FragmentManager, fragmentList: ArrayList<Fragment>?) : super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
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
        return fragmentList?.size ?: 0
    }
}