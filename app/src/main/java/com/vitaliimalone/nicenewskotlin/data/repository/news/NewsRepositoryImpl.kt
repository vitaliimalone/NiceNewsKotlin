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
            val newsList = newsRepositoryRemote.fetchTopHeadlines(category, sharedPreferences.getString("Country", "us")!!)
            newsRepositoryLocal.storeNews(newsList)
            newsList
        } catch (e: Exception) {
            newsRepositoryLocal.getNews(category)
        }
    }

    override suspend fun updateNews(news: News) {
        newsRepositoryLocal.updateNews(news)
    }

    override suspend fun getFavorites(): List<News> {
        return newsRepositoryLocal.getFavorites()
    }
}