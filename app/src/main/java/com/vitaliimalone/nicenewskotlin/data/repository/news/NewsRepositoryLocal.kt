package com.vitaliimalone.nicenewskotlin.data.repository.news

import com.vitaliimalone.nicenewskotlin.data.database.news.NewsDao
import com.vitaliimalone.nicenewskotlin.domain.entities.News

class NewsRepositoryLocal(private val newsDao: NewsDao) {

    fun storeNews(news: List<News>) {
        val category = news[0].category ?: return
        newsDao.deleteAllByCategory(category)
        newsDao.insertAll(news)
    }
}