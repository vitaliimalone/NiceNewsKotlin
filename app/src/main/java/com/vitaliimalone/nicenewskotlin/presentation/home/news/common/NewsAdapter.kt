package com.vitaliimalone.nicenewskotlin.presentation.home.news.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vitaliimalone.nicenewskotlin.R
import com.vitaliimalone.nicenewskotlin.domain.entities.News
import kotlinx.android.synthetic.main.news_item.view.*

class NewsAdapter(private val listener: NewsItemClickListener) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var news: List<News> = emptyList()

    fun setData(news: List<News>) {
        this.news = news
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsItem = news[position]
        holder.itemView.apply {
            titleTextView.text = newsItem.title
            descriptionTextView.text = newsItem.description
            setOnClickListener { listener.onNewsClick() }
        }
    }

    override fun getItemCount() = news.size

    interface NewsItemClickListener {

        fun onNewsClick()
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}