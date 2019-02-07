package com.vitaliimalone.nicenewskotlin.presentation.favorites

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.vitaliimalone.nicenewskotlin.R
import com.vitaliimalone.nicenewskotlin.presentation.common.BaseFragment
import com.vitaliimalone.nicenewskotlin.presentation.favorites.common.FavoritesAdapter
import com.vitaliimalone.nicenewskotlin.utils.toast
import kotlinx.android.synthetic.main.favorites_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoritesFragment : BaseFragment() {
    private val viewModel: FavoritesViewModel by viewModel()
    private val favoritesAdapter by lazy { FavoritesAdapter(viewModel) }

    override fun getLayoutRes(): Int = R.layout.favorites_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bottomAppBar.setNavigationOnClickListener { requireActivity().onBackPressed() }
        setupAdapter()
        setupObservers()
        viewModel.loadFavorites()
    }

    private fun setupAdapter() {
        favoritesRecyclerView.adapter = favoritesAdapter
        favoritesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setupObservers() {
        viewModel.favorites.observe(this, Observer(favoritesAdapter::setData))
        viewModel.toast.observe(this, Observer { toast(it) })
        viewModel.favoriteUpdate.observe(this, Observer { favoritesAdapter.updateNews(it) })
    }

    companion object {
        fun newInstance() = FavoritesFragment()
    }
}
