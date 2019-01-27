package com.vitaliimalone.nicenewskotlin.data.repository.news

import com.vitaliimalone.nicenewskotlin.domain.entities.News

class NewsRepositoryImpl(
        private val newsRepositoryRemote: NewsRepositoryRemote,
        private val newsRepositoryLocal: NewsRepositoryLocal
) : NewsRepository {
    override suspend fun getTopHeadlines(category: News.Category): List<News> {
        return try {
            val newsList = newsRepositoryRemote.fetchTopHeadlines(category, "us")
            newsRepositoryLocal.storeNews(newsList)
            newsList
        } catch (e: Exception) {
            newsRepositoryLocal.getNews(category)
        }
    }

    override suspend fun updateNews(news: News) {
        newsRepositoryLocal.updateNews(news)
    }
}