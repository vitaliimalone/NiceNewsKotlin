package com.vitaliimalone.nicenewskotlin.data.repository.news

import android.content.SharedPreferences
import com.vitaliimalone.nicenewskotlin.domain.entities.News

class NewsRepositoryImpl(
        private val newsRepositoryRemote: NewsRepositoryRemote,
        private val newsRepositoryLocal: NewsRepositoryLocal,
        private val sharedPreferences: SharedPreferences
) : NewsRepository {
    override suspend fun getTopHeadlines(category: News.Category): List<News> {
        return try {
            val country = sharedPreferences.getString("Country", "us")!!
            val newsList = newsRepositoryRemote.fetchTopHeadlines(category, country)
            markFavorites(newsList)
            newsRepositoryLocal.storeNews(newsList)
            newsList
        } catch (e: Exception) {
            newsRepositoryLocal.getNews(category)
        }
    }

    private suspend fun markFavorites(remotes: List<News>) {
        val favorites = newsRepositoryLocal.getFavorites()
        favorites.forEach {
            if (remotes.contains(it)) {
                remotes[remotes.indexOf(it)].isFavorite = true
            }
        }
    }

    override suspend fun updateNews(news: News) {
        newsRepositoryLocal.updateNews(news)
    }

    override suspend fun getFavorites(): List<News> {
        return newsRepositoryLocal.getFavorites()
    }
}