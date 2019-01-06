package com.vitaliimalone.nicenewskotlin.presentation.home.news

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.vitaliimalone.nicenewskotlin.R
import com.vitaliimalone.nicenewskotlin.domain.entities.News
import com.vitaliimalone.nicenewskotlin.presentation.common.BaseFragment
import com.vitaliimalone.nicenewskotlin.presentation.home.news.common.NewsAdapter
import kotlinx.android.synthetic.main.news_fragment.*

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

    private lateinit var viewModel: NewsViewModel

    override fun getLayoutRes(): Int = R.layout.news_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val newsList = prepareTestData()
        val newsAdapter = NewsAdapter(this)
        newsAdapter.setData(newsList)
        newsRecyclerView.adapter = newsAdapter
        newsRecyclerView.layoutManager = LinearLayoutManager(context)

    }

    private fun prepareTestData(): List<News> {
        val list = mutableListOf<News>()
        for (i in 1..20) {
            list.add(News("Title $i", "Description $i"))
        }
        return list
    }

    override fun onNewsClick() {
        Toast.makeText(context, "Item clicked", Toast.LENGTH_SHORT).show()
    }
}
