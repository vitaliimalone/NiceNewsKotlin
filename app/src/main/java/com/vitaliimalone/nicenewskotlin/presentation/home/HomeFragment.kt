package com.vitaliimalone.nicenewskotlin.presentation.home

import android.os.Bundle
import com.vitaliimalone.nicenewskotlin.R
import com.vitaliimalone.nicenewskotlin.presentation.common.BaseFragment
import com.vitaliimalone.nicenewskotlin.presentation.home.common.HomePagerAdapter
import com.vitaliimalone.nicenewskotlin.utils.toast
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {
    private val viewModel: HomeViewModel by viewModel()

    override fun getLayoutRes(): Int = R.layout.home_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewPager.adapter = HomePagerAdapter(requireFragmentManager())
        tabLayout.setupWithViewPager(viewPager)
        bottomAppBar.replaceMenu(R.menu.home_menu)
        bottomAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_favorites -> {
                    toast("Favorites")
                    true
                }
                R.id.menu_settings -> {
                    toast("Settings")
                    true
                }
                else -> false
            }
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}
