package com.vitaliimalone.nicenewskotlin.presentation.home

import android.os.Bundle
import com.vitaliimalone.nicenewskotlin.R
import com.vitaliimalone.nicenewskotlin.presentation.common.BaseFragment
import com.vitaliimalone.nicenewskotlin.presentation.home.common.HomePagerAdapter
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {
    private val viewModel: HomeViewModel by viewModel()

    override fun getLayoutRes(): Int = R.layout.home_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewPager.adapter = HomePagerAdapter(requireFragmentManager())
        tabLayout.setupWithViewPager(viewPager)

    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}
