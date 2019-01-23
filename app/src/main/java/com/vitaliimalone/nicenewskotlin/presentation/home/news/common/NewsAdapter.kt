package com.vitaliimalone.nicenewskotlin.presentation.home.news.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vitaliimalone.nicenewskotlin.R
import com.vitaliimalone.nicenewskotlin.di.GlideApp
import com.vitaliimalone.nicenewskotlin.domain.entities.News
import kotlinx.android.synthetic.main.news_item.view.*

class NewsAdapter(private val listener: NewsItemClickListener) :
        RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
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
            setOnClickListener { listener.onNewsClick(newsItem) }
            favoriteImageView.setOnClickListener { listener.onFavoriteClick(newsItem) }
            titleTextView.text = newsItem.title
            descriptionTextView.text = newsItem.getHandyDescription()
            sourceTextView.text = newsItem.source
            dateTextView.text = newsItem.publishedAt
            favoriteImageView.setImageResource(
                if (newsItem.isFavorite) R.drawable.ic_favorite_red
                else R.drawable.ic_unfavorite_white)
            GlideApp.with(newsImageView)
                    .load(newsItem.urlToImage)
                    .centerCrop()
                    .error(R.color.default_light_gray)
                    .into(newsImageView)
        }
    }

    override fun getItemCount() = news.size

    fun updateNews(news: News) {
        notifyItemChanged(this.news.indexOf(news))
    }

    interface NewsItemClickListener {
        fun onNewsClick(news: News)

        fun onFavoriteClick(news: News)
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}