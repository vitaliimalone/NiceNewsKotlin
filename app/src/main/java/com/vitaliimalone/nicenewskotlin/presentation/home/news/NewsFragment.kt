package com.vitaliimalone.nicenewskotlin.presentation.home.news

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.vitaliimalone.nicenewskotlin.R
import com.vitaliimalone.nicenewskotlin.presentation.common.BaseFragment
import com.vitaliimalone.nicenewskotlin.presentation.home.news.common.NewsAdapter
import com.vitaliimalone.nicenewskotlin.utils.toast
import kotlinx.android.synthetic.main.news_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : BaseFragment(), NewsAdapter.NewsItemClickListener {
    companion object {
        private const val ARG_PAGE = "ARG_PAGE"

        fun newInstance(page: Int): NewsFragment {
            val args = Bundle()
            args.putInt(ARG_PAGE, page)
            val fragment = NewsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    val viewModel: NewsViewModel by viewModel()

    override fun getLayoutRes(): Int = R.layout.news_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val newsAdapter = NewsAdapter(this)
        newsRecyclerView.adapter = newsAdapter
        newsRecyclerView.layoutManager = LinearLayoutManager(context)
        viewModel.news.observe(this, Observer(newsAdapter::setData))
        viewModel.loadNews()
        viewModel.toast.observe(this, Observer { toast(it) })
    }

    override fun onNewsClick() {
        Toast.makeText(context, "Item clicked", Toast.LENGTH_SHORT).show()
    }
}
