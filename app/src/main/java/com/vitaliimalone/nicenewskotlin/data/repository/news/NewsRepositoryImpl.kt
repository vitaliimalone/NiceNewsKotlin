package com.vitaliimalone.nicenewskotlin.data.repository.news

import com.vitaliimalone.nicenewskotlin.domain.entities.News

class NewsRepositoryImpl(
    private val newsRepositoryRemote: NewsRepositoryRemote,
    private val newsRepositoryLocal: NewsRepositoryLocal
) : NewsRepository {
    override suspend fun getTopHeadlines(category: News.Category): List<News> {
        val newsList = newsRepositoryRemote.fetchTopHeadlines(category)
        newsRepositoryLocal.storeNews(newsList)
        return newsList
    }
}