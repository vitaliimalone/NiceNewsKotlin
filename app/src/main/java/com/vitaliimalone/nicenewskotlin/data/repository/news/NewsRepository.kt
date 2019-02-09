package com.vitaliimalone.nicenewskotlin.data.repository.news

import com.vitaliimalone.nicenewskotlin.domain.entities.News

interface NewsRepository {
    suspend fun getTopHeadlines(category: News.Category): List<News>

    suspend fun updateNews(news: News)

    suspend fun getFavorites(): List<News>
}