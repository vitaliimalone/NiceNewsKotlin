package com.vitaliimalone.nicenewskotlin.presentation.favorites.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vitaliimalone.nicenewskotlin.R
import com.vitaliimalone.nicenewskotlin.di.GlideApp
import com.vitaliimalone.nicenewskotlin.domain.entities.News
import kotlinx.android.synthetic.main.news_item.view.*

class FavoritesAdapter(private val listener: FavoritesClickListener) :
        RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>() {
    private var news = mutableListOf<News>()

    fun setData(news: List<News>) {
        this.news = news.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return FavoritesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
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

    fun removeNews(news: News) {
        val index = this.news.indexOf(news)
        this.news.removeAt(index)
        notifyItemRemoved(index)
    }

    interface FavoritesClickListener {
        fun onNewsClick(news: News)

        fun onFavoriteClick(news: News)
    }

    class FavoritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
