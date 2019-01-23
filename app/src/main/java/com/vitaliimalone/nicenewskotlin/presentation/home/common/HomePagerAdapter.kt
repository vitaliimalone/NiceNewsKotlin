package com.vitaliimalone.nicenewskotlin.presentation.home.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.vitaliimalone.nicenewskotlin.domain.entities.News
import com.vitaliimalone.nicenewskotlin.presentation.home.news.NewsFragment

class HomePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val fragments: List<Fragment> = listOf(
            NewsFragment.newInstance(News.Category.GENERAL),
            NewsFragment.newInstance(News.Category.BUSINESS),
            NewsFragment.newInstance(News.Category.ENTERTAINMENT),
            NewsFragment.newInstance(News.Category.HEALTH),
            NewsFragment.newInstance(News.Category.SCIENCE),
            NewsFragment.newInstance(News.Category.SPORTS),
            NewsFragment.newInstance(News.Category.TECHNOLOGY)
    )

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount() = fragments.size

    override fun getPageTitle(position: Int) = when (position) {
        0 -> News.Category.GENERAL.name
        1 -> News.Category.BUSINESS.name
        2 -> News.Category.ENTERTAINMENT.name
        3 -> News.Category.HEALTH.name
        4 -> News.Category.SCIENCE.name
        5 -> News.Category.SPORTS.name
        6 -> News.Category.TECHNOLOGY.name
        else -> throw IllegalArgumentException("There's no such category")
    }
}
