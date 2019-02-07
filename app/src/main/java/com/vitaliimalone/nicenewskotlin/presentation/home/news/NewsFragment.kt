package com.vitaliimalone.nicenewskotlin.presentation.home.news

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.vitaliimalone.nicenewskotlin.R
import com.vitaliimalone.nicenewskotlin.domain.entities.News
import com.vitaliimalone.nicenewskotlin.presentation.common.BaseFragment
import com.vitaliimalone.nicenewskotlin.presentation.home.news.common.NewsAdapter
import com.vitaliimalone.nicenewskotlin.utils.toast
import kotlinx.android.synthetic.main.news_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : BaseFragment() {
    private val viewModel: NewsViewModel by viewModel()
    private val newsAdapter by lazy { NewsAdapter(viewModel) }

    override fun getLayoutRes(): Int = R.layout.news_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupAdapter()
        setupObservers()
        viewModel.loadNews(arguments!!.getSerializable(ARG_CATEGORY) as News.Category)
    }

    private fun setupAdapter() {
        newsRecyclerView.adapter = newsAdapter
        newsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setupObservers() {
        viewModel.news.observe(this, Observer(newsAdapter::setData))
        viewModel.toast.observe(this, Observer { toast(it) })
        viewModel.favoriteUpdate.observe(this, Observer { newsAdapter.updateNews(it) })
    }

    companion object {
        private const val ARG_CATEGORY = "ARG_CATEGORY"

        fun newInstance(category: News.Category): NewsFragment {
            val args = Bundle()
            args.putSerializable(ARG_CATEGORY, category)
            val fragment = NewsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
