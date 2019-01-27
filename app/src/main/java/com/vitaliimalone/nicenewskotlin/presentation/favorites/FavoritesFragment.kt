package com.vitaliimalone.nicenewskotlin.presentation.favorites

import com.vitaliimalone.nicenewskotlin.R
import com.vitaliimalone.nicenewskotlin.presentation.common.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoritesFragment : BaseFragment() {
    private val viewModel: FavoritesViewModel by viewModel()

    override fun getLayoutRes(): Int = R.layout.favorites_fragment

    companion object {
        fun newInstance() = FavoritesFragment()
    }
}
