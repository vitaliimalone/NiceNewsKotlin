package com.vitaliimalone.nicenewskotlin.presentation.home.common

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.vitaliimalone.nicenewskotlin.presentation.home.news.NewsFragment

class HomePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int) = NewsFragment.newInstance(position)

    override fun getCount() = 7

    override fun getPageTitle(position: Int) = when (position) {
        0 -> "Category $position"
        1 -> "Category $position"
        2 -> "Category $position"
        3 -> "Category $position"
        4 -> "Category $position"
        5 -> "Category $position"
        6 -> "Category $position"
        else -> "Error"
    }
}
