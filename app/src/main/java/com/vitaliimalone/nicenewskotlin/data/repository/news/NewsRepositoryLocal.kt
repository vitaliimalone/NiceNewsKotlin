package com.vitaliimalone.nicenewskotlin.data.repository.news

import com.vitaliimalone.nicenewskotlin.data.database.news.NewsDao
import com.vitaliimalone.nicenewskotlin.data.repository.common.BaseRepositoryLocal
import com.vitaliimalone.nicenewskotlin.domain.entities.News

class NewsRepositoryLocal(private val newsDao: NewsDao) : BaseRepositoryLocal() {
    suspend fun storeNews(news: List<News>) {
        accessData {
            newsDao.deleteAll()
            newsDao.insertAll(news)
        }
    }
}
