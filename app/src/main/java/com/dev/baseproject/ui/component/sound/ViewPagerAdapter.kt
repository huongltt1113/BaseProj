package com.dev.baseproject.ui.component.sound

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


class ViewPagerAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {

    private var dataList = mutableListOf<Fragment>()

    fun setData(newList: List<Fragment>) {
        dataList.clear()
        dataList.addAll(newList)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun createFragment(position: Int): Fragment {
        return dataList[position]
    }
}